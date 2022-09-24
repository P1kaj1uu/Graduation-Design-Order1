package com.notfound.crm.sys.controller;

import com.notfound.crm.common.base.Query;
import com.notfound.crm.common.base.Result;
import com.notfound.crm.common.validator.ValidatorUtil;
import com.notfound.crm.sys.form.PersonalForm;


import com.notfound.crm.sys.service.IPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/personal")
public class PersonalController {
    @Autowired
    private IPersonalService personalService;

    /**
     * 查询表中所有信息（进入表首页使用）
     * @param query
     * @return
     */
    // http
    @RequestMapping("/list")
    @ResponseBody
    public Result list(Query query){
        Result list = personalService.queryPage(query);
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
        Result query = personalService.query(id);
        return query;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(Integer id){
        Result delete = personalService.delete(id);
        return delete;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(PersonalForm personalForm){
        System.out.println(personalForm);
//        ValidatorUtil.validator(personalForm);//验证
        Result update = personalService.update(personalForm);
        return update;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Result insert(PersonalForm personalForm){
        ValidatorUtil.validator(personalForm);//验证
        System.out.println(personalForm);
        personalForm.setRankk("0");
        Result add = personalService.add(personalForm);
        return add;
    }
}
