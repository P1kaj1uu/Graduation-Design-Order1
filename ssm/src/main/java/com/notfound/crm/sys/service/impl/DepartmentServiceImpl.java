package com.notfound.crm.sys.service.impl;

import com.notfound.crm.common.service.impl.BaseServiceImpl;
import com.notfound.crm.sys.form.DepartmentForm;
import com.notfound.crm.sys.mapper.DepartmentMapper;
import com.notfound.crm.sys.mapper.EmployeeMapper;
import com.notfound.crm.sys.service.IDepartmentService;
import com.notfound.crm.sys.vo.DepartmentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description department业务层实现类
 */
@Service
public class DepartmentServiceImpl extends BaseServiceImpl<DepartmentForm> implements IDepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    public DepartmentServiceImpl(DepartmentMapper departmentMapper) {
        super(departmentMapper);
    }
}
