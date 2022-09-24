package com.notfound.crm.sys.service.impl;

import com.notfound.crm.sys.domain.Role;
import com.notfound.crm.sys.mapper.EmployeeMapper;
import com.notfound.crm.common.base.CodeMsg;
import com.notfound.crm.common.base.Result;
import com.notfound.crm.common.service.impl.BaseServiceImpl;
import com.notfound.crm.sys.form.EmployeeForm;
import com.notfound.crm.sys.service.IEmployeeService;
import com.notfound.crm.sys.vo.EmployeeVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description:    User服务层实现类
 */
@Service
public class EmployeeServiceImpl extends BaseServiceImpl<EmployeeForm> implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    //告诉基类当前需要用到的Mapper文件
    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
        super(employeeMapper);
    }

    /**
     * 登录方法
     * @param employeeForm
     * @return
     */
    @Override
    public Result login(EmployeeForm employeeForm, String securityCode, HttpServletRequest request){
        EmployeeVO data = employeeMapper.login(employeeForm);

        if(data == null){   //查询记过如果为空，则该用户名错误
            return new Result(CodeMsg.LOGIN_FAILD_WRONG_USERNAME);    //登录失败，用户名错误
        }else { //查询结果不为空，证明该用户名正确

            //判断该用户名对应的密码是否与数据库中的密码相同，如果相同，那么则允许该用户登录系统，若不相同则返回错误信息
            if(data.getPassword().equals(employeeForm.getPassword())){
                String  authCode = (String) request.getSession().getAttribute("SecurityCode");
                System.out.println(request.getCookies());

                //校验用户填写的验证码是否正确
                System.out.println("Session中的验证码："+authCode);
                if(securityCode.equals(authCode)){
                    Integer role_id = Integer.parseInt(data.getRole());
                    List<String> role_list = employeeMapper.queryPermissionList(role_id);
//                    System.out.println("权限列表："+role_list);
                    //将用户信息存储进session
                    request.getSession().setAttribute("CURR_USER",data);
                    request.getSession().setAttribute("ROLE_LIST",role_list);
                    System.out.println("********************用户的权限有："+role_list);

                    return new Result();    //登录成功
                }else {
                    return new Result(CodeMsg.LOGIN_FAILD_WRONG_AUTHCODE);  //登录失败，验证码错误
                }
            }else {
                return new Result(CodeMsg.LOGIN_FAILD_WRONG_PASSWORD); //登录失败，密码错误
            }
        }
    }

    @Override
    public Result updateByPrimaryKeySelective(EmployeeVO employeeVO){


        //删除修改的权限名字关系表的所有权限ID
        employeeMapper.deleteEmployeeAndRoleRelation(employeeVO.getId());
        //再添加新的关系表数据
        for(Role role :employeeVO.getRoleList()) {
            employeeMapper.insertEmployeeAndRoleRelation(employeeVO.getId(), role.getId());
        }
        employeeMapper.updateByPrimaryKeySelective(employeeVO);
        return new Result();
    }

    @Override
    public Result delete(Integer id) {
        employeeMapper.delete(id);
        //通过删除的员工ID同时删除员工和角色关系表的相关数据
        employeeMapper.deleteEmployeeAndRoleRelation(id);
        return new Result();
    }

    @Override
    public Result deleteByIdList(Integer[] ids) {
        employeeMapper.deleteByIdList(ids);
        return new Result();
    }

    @Override
    public Result add(EmployeeForm employeeForm) {
        employeeMapper.insert(employeeForm);
        //用户添加在业务层调用方法employeeMapper.insert(employeeForm)实现新增操作，将数据添加保存进employee表中，employeeMapper.insertEmployeeAndRoleRelation(employeeForm.getId(), role.getId());
        //执行代码将用户id与角色id储存到employee_role表中，一个用户id对应一个角色id。
        //再添加新的关系表数据
        for(Role role :employeeForm.getRoleList()) {
            employeeMapper.insertEmployeeAndRoleRelation(employeeForm.getId(), role.getId());
        }
        return new Result();
    }

    @Override
    public Result addBatch(List<EmployeeVO> list) {
        for(EmployeeVO data: list) {
            //获取mapper
            EmployeeMapper employeeMapper = sqlSessionTemplate.getMapper(EmployeeMapper.class);

            //调用批量插入数据
            employeeMapper.addBatch(data);
            //再添加新的关系表数据
            for(Role role :data.getRoleList()) {
                employeeMapper.insertEmployeeAndRoleRelation(data.getId(), role.getId());
            }
        }
        return new Result();
    }

    @Override
    public Result queryByIdList(Integer[] ids) {

        List<EmployeeVO> employee = employeeMapper.queryByIdList(ids);

        return new Result(employee);
    }
}
