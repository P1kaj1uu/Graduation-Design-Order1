package com.notfound.crm.sys.mapper;

import com.notfound.crm.common.mapper.BaseMapper;
import com.notfound.crm.sys.domain.Item;
import com.notfound.crm.sys.form.ItemForm;
import com.notfound.crm.sys.vo.ItemVO;

import java.util.List;

public interface ItemMapper extends BaseMapper<ItemForm, ItemVO> {

     int updatestatus(Item item);
     //状态列表
     List<Item> select(int status);
     List<Item> moselect(Item item);

}
