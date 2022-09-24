package com.notfound.crm.sys.controller;

import com.notfound.crm.common.base.Query;
import com.notfound.crm.common.base.Result;
import com.notfound.crm.common.validator.ValidatorUtil;
import com.notfound.crm.sys.form.DepartmentForm;
import com.notfound.crm.sys.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Description 部门(department)的web层
 */
@Controller
@RequestMapping("/depart")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;

    /**
     * 查询表中所有信息（进入表首页使用）
     * @param query
     * @return
     */
    // http
    @RequestMapping("/list")
    @ResponseBody
    public Result first(Query query){
        Result list = departmentService.queryPage(query);
        return list;
    }

    /**
     * 根据id查询表中单个信息（表中编辑使用）
     * @param id
     * @return
     */
    @RequestMapping("/query")
    @ResponseBody
    public Result query(Integer id){
        Result query = departmentService.query(id);
        return query;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(Integer id){
        Result delete = departmentService.delete(id);
        return delete;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(DepartmentForm departmentForm){
        System.out.println(departmentForm);
        ValidatorUtil.validator(departmentForm);//验证
        Result update = departmentService.update(departmentForm);
        return update;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Result insert(DepartmentForm departmentForm){
        ValidatorUtil.validator(departmentForm);//验证
        Result add = departmentService.add(departmentForm);
        return add;
    }
}
