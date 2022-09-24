package com.notfound.crm.sys.controller;

import com.notfound.crm.common.base.Query;
import com.notfound.crm.common.base.Result;
import com.notfound.crm.common.validator.ValidatorUtil;
import com.notfound.crm.sys.domain.Employee;
import com.notfound.crm.sys.domain.Item;
import com.notfound.crm.sys.form.ItemForm;
import com.notfound.crm.sys.service.IEmployeeService;
import com.notfound.crm.sys.service.IItemService;
import com.notfound.crm.sys.service.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/item")
public class ItemController{
    @Autowired
    private IItemService itemService;
    @Autowired
    private IItemService itemServiceImpl;
    /**
     * 查询表中所有信息（进入表首页使用）
     * @param query
     * @return
     */
    // http
    @RequestMapping("/list")
    @ResponseBody
    public Result first(Query query){
        Result list = itemService.queryPage(query);
        return list;
    }
//未审核的竞赛列表
    @RequestMapping("/select")
    @ResponseBody
    public Result select(Query query){
        Result list = itemService.select(query);
        return list;
    }

    @RequestMapping("/moselect")
    @ResponseBody
    public Result moselect(Query query){
        Result list = itemService.moselect(query);
        return list;
    }
//通过的竞赛列表
    @RequestMapping("/1")
    @ResponseBody
    public Result select1(Query query){
        Result list = itemService.select1(query);
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
        Result query = itemService.query(id);
        return query;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(Integer id){
        Result delete = itemService.delete(id);
        return delete;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(ItemForm itemForm){
        System.out.println(itemForm);
        ValidatorUtil.validator(itemForm);//验证
        Item item=new Item();
        item.setStatus(Item.STATUS_SUCCESS);
        Result update = itemService.update(itemForm);
        return update;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Result insert(ItemForm itemForm){
        ValidatorUtil.validator(itemForm);//验证
        System.out.println(itemForm);
        itemForm.setStatus(Item.STATUS_wei);
        Result add = itemService.add(itemForm);
        return add;
    }

    @RequestMapping("/updatestatus")
    @ResponseBody
    public int updatestatus(Item item){
//        ValidatorUtil.validator(itemForm);//验证
        System.out.println(item);
        item.setStatus(Item.STATUS_SUCCESS);
        int r = itemService.updatestaus(item);
        return r;
    }

    @RequestMapping("/updatestatus1")
    @ResponseBody
    public int updatestatus1(Item item){
//        ValidatorUtil.validator(itemForm);//验证
        System.out.println(item);
        item.setStatus(Item.STATUS_FALI);
        int r = itemService.updatestaus1(item);
        return r;
    }

    @RequestMapping("/queryPage")
    @ResponseBody
    //http://localhost:8888/sys/queryPage
    public Result queryPage(Query query){
        System.out.println("模糊查询条件是："+query);
        Item item=new Item();

        Result result = itemServiceImpl.queryPage(query);
        return result;
    }
}
