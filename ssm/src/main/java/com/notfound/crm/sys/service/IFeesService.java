package com.notfound.crm.sys.service;

import com.notfound.crm.common.service.IBaseService;
import com.notfound.crm.sys.domain.Fees;
import com.notfound.crm.sys.form.FeesForm;

public interface IFeesService extends IBaseService<FeesForm> {
    int heji(Fees fees);
}
