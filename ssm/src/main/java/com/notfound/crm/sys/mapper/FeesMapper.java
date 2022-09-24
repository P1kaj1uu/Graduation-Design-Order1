package com.notfound.crm.sys.mapper;

import com.notfound.crm.common.mapper.BaseMapper;
import com.notfound.crm.sys.domain.Fees;
import com.notfound.crm.sys.form.FeesForm;
import com.notfound.crm.sys.vo.FeesVO;

public interface FeesMapper extends BaseMapper<FeesForm, FeesVO> {
    int heji(Fees fees);
}
