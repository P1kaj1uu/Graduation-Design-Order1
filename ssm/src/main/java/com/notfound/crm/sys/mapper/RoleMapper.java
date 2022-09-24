package com.notfound.crm.sys.mapper;

import com.notfound.crm.common.mapper.BaseMapper;
import com.notfound.crm.sys.form.RoleForm;
import com.notfound.crm.sys.vo.RoleVO;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface RoleMapper extends BaseMapper<RoleForm, RoleVO> {
    /**
     * 根据username查找到role后给shiro做验证
     * @param username
     * @return
     * @throws Exception
     */
    Set<String> queryRoleByUserName(String username);

    /**
     * 增加角色和权限中间表信息
     * @param
     * @return
     */
    int insertRoleAndPermissionRelation(@Param("eid")Integer rid, @Param("rid")Integer pid);

    /**
     * 删除角色和权限中间表信息
     * @param
     * @return
     */
    int deleteRoleAndPermissionRelation(Integer id);

}
