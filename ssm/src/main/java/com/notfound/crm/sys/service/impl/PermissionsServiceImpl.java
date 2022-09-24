package com.notfound.crm.sys.service.impl;

import com.notfound.crm.common.service.impl.BaseServiceImpl;
import com.notfound.crm.sys.form.PermissionsForm;
import com.notfound.crm.sys.mapper.PermissionsMapper;
import com.notfound.crm.sys.service.IPermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 */
@Service
public class PermissionsServiceImpl extends BaseServiceImpl<PermissionsForm> implements IPermissionsService {

    @Autowired
    private PermissionsMapper permissionsMapper;

    public PermissionsServiceImpl(PermissionsMapper permissionsMapper) {
        super(permissionsMapper);
    }
}
