package com.notfound.crm.sys.controller;

import com.notfound.crm.common.base.Query;
import com.notfound.crm.common.base.Result;
import com.notfound.crm.common.validator.ValidatorUtil;
import com.notfound.crm.sys.form.FeesForm;
import com.notfound.crm.sys.service.IFeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

@Controller
@RequestMapping("/fees")
public class FeesController {
    @Autowired
    private IFeesService feesService;

    /**
     * 查询表中所有信息（进入表首页使用）
     * @param query
     * @return
     */
    // http
    @RequestMapping("/list")
    @ResponseBody
    public Result list(Query query){
        Result list = feesService.queryPage(query);
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
        Result query = feesService.query(id);
        return query;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(Integer id){
        Result delete = feesService.delete(id);
        return delete;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(FeesForm feesForm){
        System.out.println(feesForm);
        ValidatorUtil.validator(feesForm);//验证
        Result update = feesService.update(feesForm);
        return update;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Result insert(FeesForm feesForm){
        ValidatorUtil.validator(feesForm);//验证
        System.out.println(feesForm+"数据");
        BigDecimal decimal = feesForm.getEnroll().add(feesForm.getGuide()).add(feesForm.getOther());
        feesForm.setHeji(decimal);
        Result add = feesService.add(feesForm);
        return add;
    }
}
