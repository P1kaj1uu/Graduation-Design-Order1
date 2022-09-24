package com.notfound.crm.sys.controller;

import com.notfound.crm.common.base.Query;
import com.notfound.crm.common.base.Result;
import com.notfound.crm.common.validator.ValidatorUtil;
import com.notfound.crm.sys.form.RoleForm;
import com.notfound.crm.sys.service.IRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    //查询全部角色信息
    @RequiresPermissions("role:queryPage")
    @RequestMapping("/queryPage")
    @ResponseBody
    public Result queryPage(Query query){

        Result result = roleService.queryPage(query);

        return result;
    }

    //根据id查询角色信息
    @RequestMapping("/queryRole")
    @ResponseBody
    public Result query(Integer id){

        ValidatorUtil.validator(id);
        Result result = roleService.query(id);

        return result;

    }

    //根据id删除角色信息
    @RequestMapping("/deleteRole")
    @ResponseBody
    public Result delete(Integer id){
        ValidatorUtil.validator(id);
        Result result = roleService.delete(id);
        return result;
    }

    //增加角色信息
    @RequestMapping("/addRole")
    @ResponseBody
    public Result add(RoleForm roleForm){
        ValidatorUtil.validator(roleForm);
        Result result = roleService.add(roleForm);
        return result;
    }

    //修改角色信息
    @RequestMapping("/updateRole")
    @ResponseBody
    public Result update(RoleForm roleForm){

        ValidatorUtil.validator(roleForm);
        Result result = roleService.update(roleForm);

        return result;
    }


}

