package com.notfound.crm.sys.service.impl;

import com.notfound.crm.common.mapper.BaseMapper;
import com.notfound.crm.common.service.impl.BaseServiceImpl;
import com.notfound.crm.sys.domain.Personal;
import com.notfound.crm.sys.form.PersonalForm;
import com.notfound.crm.sys.mapper.PersonalMapper;
import com.notfound.crm.sys.service.IPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalServiceImpl extends BaseServiceImpl<PersonalForm> implements IPersonalService {
    @Autowired
    private PersonalMapper personalMapper;
    public PersonalServiceImpl(PersonalMapper personalMapper) {
        super(personalMapper);
    }

}
