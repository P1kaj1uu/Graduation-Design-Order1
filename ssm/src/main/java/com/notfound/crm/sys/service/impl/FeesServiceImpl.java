package com.notfound.crm.sys.service.impl;

import com.notfound.crm.common.mapper.BaseMapper;
import com.notfound.crm.common.service.impl.BaseServiceImpl;
import com.notfound.crm.sys.domain.Fees;
import com.notfound.crm.sys.form.FeesForm;
import com.notfound.crm.sys.mapper.FeesMapper;
import com.notfound.crm.sys.service.IFeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeesServiceImpl extends BaseServiceImpl<FeesForm> implements IFeesService {
    @Autowired
    private FeesMapper feesMapper;
    public FeesServiceImpl(FeesMapper feesMapper) {
        super(feesMapper);
    }

    @Override
    public int heji(Fees fees) {
        return 0;
    }
}
