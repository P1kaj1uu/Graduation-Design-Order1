package com.notfound.crm.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.notfound.crm.common.base.PageInfo;
import com.notfound.crm.common.base.Query;
import com.notfound.crm.common.base.Result;
import com.notfound.crm.common.service.impl.BaseServiceImpl;
import com.notfound.crm.sys.domain.Item;
import com.notfound.crm.sys.form.ItemForm;
import com.notfound.crm.sys.mapper.ItemMapper;
import com.notfound.crm.sys.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl extends BaseServiceImpl<ItemForm> implements IItemService {
    @Autowired
    private ItemMapper itemMapper;

    public ItemServiceImpl(ItemMapper itemMapper) {super(itemMapper);}

    @Override
    public int updatestaus(Item item) {
        item.setStatus(Item.STATUS_SUCCESS);
        int request=itemMapper.updatestatus(item);
        return request;
    }

    public int updatestaus1(Item item) {
        item.setStatus(Item.STATUS_FALI);
        int request=itemMapper.updatestatus(item);
        return request;
    }

    @Override
    public Result select(Query query) {
        Page<Object> data = PageHelper.startPage(query.getCurrentPage(), query.getPageSize());

        List list = itemMapper.select(Item.STATUS_wei);

        PageInfo pageData = new PageInfo(data.getPageNum(), data.getPageSize(), data.getTotal(), data.getResult());

        return new Result(pageData);
    }

    @Override
    public Result select1(Query query) {
        Page<Object> data = PageHelper.startPage(query.getCurrentPage(), query.getPageSize());

        List list = itemMapper.select(Item.STATUS_SUCCESS);

        PageInfo pageData = new PageInfo(data.getPageNum(), data.getPageSize(), data.getTotal(), data.getResult());

        return new Result(pageData);
    }

    @Override
    public Result moselect(Query query) {
        Item item=new Item();
        List<Item> it = itemMapper.moselect(item);
        return null;
    }

}
