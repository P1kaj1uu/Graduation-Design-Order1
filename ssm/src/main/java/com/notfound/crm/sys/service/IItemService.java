package com.notfound.crm.sys.service;

import com.notfound.crm.common.base.Query;
import com.notfound.crm.common.base.Result;
import com.notfound.crm.common.service.IBaseService;
import com.notfound.crm.sys.domain.Item;
import com.notfound.crm.sys.form.ItemForm;

public interface IItemService extends IBaseService<ItemForm> {

      int updatestaus(Item item);
      int updatestaus1(Item item);
      //查看未审核的列表方法
      Result select(Query query);
      //查看通过的列表方法
      Result select1(Query query);

      Result moselect(Query query);
}
