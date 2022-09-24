package com.notfound.crm.sys.controller;

import com.notfound.crm.common.base.Query;
import com.notfound.crm.common.base.Result;
import com.notfound.crm.common.validator.ValidatorUtil;
import com.notfound.crm.sys.form.PermissionsForm;
import com.notfound.crm.sys.service.IPermissionsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/permissions")
public class PermissionsController {
    @Autowired
    private IPermissionsService permissionsService;

    //查询全部权限信息
    @RequestMapping("/queryPagePermissions")
    @ResponseBody
//    @RequiresPermissions("permissions:queryPagePermissions")
    public Result queryPage(Query query){

        Result result = permissionsService.queryPage(query);
        result.setCode(0);

        return result;
    }

    //根据id查询权限信息
    @RequestMapping("/queryPermissions")
    @ResponseBody
    public Result query(Integer id){

        ValidatorUtil.validator(id);
        Result result = permissionsService.query(id);

        return result;
    }

    //根据id删除权限信息
    @RequestMapping("/deletePermissions")
    @ResponseBody
    public Result delete(Integer id){

        ValidatorUtil.validator(id);
        Result result = permissionsService.delete(id);

        return result;
    }

    //增加权限信息
    @RequestMapping("/addPermissions")
    @ResponseBody
    public Result add(PermissionsForm permissionsForm){

        ValidatorUtil.validator(permissionsForm);
        Result result = permissionsService.add(permissionsForm);

        return result;
    }

    //修改权限信息
    @RequestMapping("/updatePermissions")
    @ResponseBody
    public Result update(PermissionsForm permissionsForm){

        ValidatorUtil.validator(permissionsForm);
        Result result = permissionsService.update(permissionsForm);

        return result;
    }
}
