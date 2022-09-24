package com.notfound.crm.sys.mapper;

import com.notfound.crm.common.mapper.BaseMapper;
import com.notfound.crm.sys.form.PermissionsForm;
import com.notfound.crm.sys.vo.PermissionsVO;

import java.util.Set;

public interface PermissionsMapper extends BaseMapper<PermissionsForm, PermissionsVO> {

    /**
     *根据username查找到对应权限后给shiro做验证
     * @param username
     * @return
     */
    Set<String> queryPermissionsByUsername(String username);
}
