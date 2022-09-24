package com.notfound.crm.sys.mapper;

import com.notfound.crm.common.mapper.BaseMapper;
import com.notfound.crm.sys.domain.Employee;
import com.notfound.crm.sys.form.EmployeeForm;
import com.notfound.crm.sys.vo.EmployeeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper extends BaseMapper<EmployeeForm, EmployeeVO> {
    /**
     * 登录接口
     * @param employeeForm
     * @return
     */
    EmployeeVO login(EmployeeForm employeeForm);

    /**
     * 注销或退出登录接口
     * @param employeeVO
     * @return
     */
    int updateByPrimaryKeySelective(EmployeeVO employeeVO);

    /**
     * 根据前端传入的id数组批量删除数据
     * @param ids
     * @return
     */
    int deleteByIdList(@Param("ids") Integer[] ids);

    /**
     * 批量插入数据
     * @param data
     * @return
     */
    int addBatch(EmployeeVO data);

    /**
     * 通过name查询
     * @param username
     * @return
     */
    EmployeeVO queryEmployeeByName(String username)throws Exception;

    /**
     * 增加一条员工和角色中间表信息
     * @param
     * @return
     */
    int insertEmployeeAndRoleRelation(@Param("eid")Integer eid, @Param("rid")Integer rid);
int update(EmployeeVO employeeVO);
    /**
     * 删除一条员工和角色中间表信息
     * @param
     * @return
     */
    int deleteEmployeeAndRoleRelation(Integer id);

    /**
     * 根据id列表查询数据
     * @param ids
     * @return
     */
    List<EmployeeVO> queryByIdList(@Param("ids") Integer[] ids);

    /**
     * 根据用户角色id
     * @param id
     * @return
     */
    List<String> queryPermissionList(Integer id);
}