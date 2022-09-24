package com.notfound.crm.sys.service.impl;

import com.notfound.crm.common.base.Query;
import com.notfound.crm.common.base.Result;
import com.notfound.crm.common.service.impl.BaseServiceImpl;
import com.notfound.crm.sys.domain.Permissions;
import com.notfound.crm.sys.form.RoleForm;
import com.notfound.crm.sys.mapper.PermissionsMapper;
import com.notfound.crm.sys.mapper.RoleMapper;
import com.notfound.crm.sys.service.IRoleService;
import com.notfound.crm.sys.vo.PermissionsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleForm> implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionsMapper permissionsMapper;

    public RoleServiceImpl(RoleMapper roleMapper) {
        super(roleMapper);
    }

    @Override
    public Result add(RoleForm roleForm) {
        roleMapper.insert(roleForm);
        //通过角色的权限名字得到的权限数据
//        Permissions permissions = permissionsMapper.queryPermissionByRolePermission(roleForm.getPermission());
        //添加中间表的角色ID和权限ID
        for(Permissions permissions :roleForm.getPermissionsList()) {
            roleMapper.insertRoleAndPermissionRelation(roleForm.getId(), permissions.getId());
        }
        return new Result();
    }

    @Override
    public Result delete(Integer id) {
        roleMapper.delete(id);
        //通过删除的角色ID同时删除关系表的相关数据
        roleMapper.deleteRoleAndPermissionRelation(id);
        return new Result();
    }

    @Override
    public Result update(RoleForm roleForm) {
        roleMapper.update(roleForm);
        //通过修改的角色的权限名字得到相关的权限数据
//        Permissions permissions = permissionsMapper.queryPermissionByRolePermission(roleForm.getPermission());
        //删除修改的权限名字关系表的所有权限ID
        roleMapper.deleteRoleAndPermissionRelation(roleForm.getId());
        //再添加新的关系表数据
        Query query = new Query();
        List<PermissionsVO> permissionsList = permissionsMapper.selectList(query);
        for(Permissions permissions :permissionsList) {
            roleMapper.insertRoleAndPermissionRelation(roleForm.getId(), permissions.getId());
        }
        return new Result();
    }
}

