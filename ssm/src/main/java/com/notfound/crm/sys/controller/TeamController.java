package com.notfound.crm.sys.controller;

import com.notfound.crm.common.base.Query;
import com.notfound.crm.common.base.Result;
import com.notfound.crm.common.validator.ValidatorUtil;
import com.notfound.crm.sys.form.TeamForm;
import com.notfound.crm.sys.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private ITeamService teamService;

    /**
     * 查询表中所有信息（进入表首页使用）
     * @param query
     * @return
     */
    // http
    @RequestMapping("/list")
    @ResponseBody
    public Result list(Query query){
        Result list = teamService.queryPage(query);
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
        Result query = teamService.query(id);
        return query;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(Integer id){
        Result delete = teamService.delete(id);
        return delete;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(TeamForm teamForm){
        System.out.println(teamForm);
        ValidatorUtil.validator(teamForm);//验证
        Result update = teamService.update(teamForm);
        return update;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Result insert(TeamForm teamForm){
        ValidatorUtil.validator(teamForm);//验证
        System.out.println(teamForm);
        teamForm.setRankk("0");
        Result add = teamService.add(teamForm);
        return add;
    }
}
