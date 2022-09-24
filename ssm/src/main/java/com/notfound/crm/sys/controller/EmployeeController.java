package com.notfound.crm.sys.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.alibaba.fastjson.JSON;
import com.notfound.crm.common.base.PageInfo;
import com.notfound.crm.common.base.Query;
import com.notfound.crm.common.base.Result;
import com.notfound.crm.common.validator.ValidatorUtil;
import com.notfound.crm.sys.domain.Employee;
import com.notfound.crm.sys.form.EmployeeForm;
import com.notfound.crm.sys.service.IEmployeeService;
import com.notfound.crm.sys.util.easyexcel.EasyExcelUtil;
import com.notfound.crm.sys.util.easyexcel.EmployeeReadListener;
import com.notfound.crm.sys.vo.EmployeeVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description: 这里是员工类的controller，端口访问
 */
@Controller
@RequestMapping("/sys")
public class EmployeeController implements BeanFactoryAware {

    @Autowired
    private IEmployeeService employeeServiceImpl;

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @RequestMapping("/checkAdmin")
    @ResponseBody
    //http://localhost:8888/sys/login
    public Boolean checkAdmin(HttpServletRequest request){
        EmployeeVO data =(EmployeeVO) request.getSession().getAttribute("CURR_USER");

        return data.getAdmin() == 1;
    }


    @RequestMapping("/login")
    @ResponseBody
    //http://localhost:8888/sys/login
    public Result login(EmployeeForm employeeForm, String securityCode, HttpServletRequest request){

        Result result = employeeServiceImpl.login(employeeForm, securityCode, request);
        return result;
    }

    @RequestMapping("/loginOut")
    @ResponseBody
    //http://localhost:8888/sys/loginOut
    public Result loginOut(EmployeeForm employeeForm, HttpServletRequest request){
        request.setAttribute("CURR_USER",null);     //注销、退出登录清空Session

        return new Result();
    }
    
    @RequestMapping("/getAuthCode.do")
    @ResponseBody
    //http://localhost:8888/sys/getAuthCode.do
    public void testInterceptor(HttpSession session, HttpServletResponse response){

        CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(90, 40, 4, 10);
        //得到验证码
        String authCode = circleCaptcha.getCode();
        System.out.println(authCode);
        session.setAttribute("SecurityCode", authCode);
        try {
            circleCaptcha.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/queryPage")
    @ResponseBody
    //http://localhost:8888/sys/queryPage
    public Result queryPage(Query query){
        System.out.println("模糊查询条件是："+query);
        Employee employee=new Employee();

        Result result = employeeServiceImpl.queryPage(query);
        return result;
    }

    @RequestMapping("/addEmployee")
    @ResponseBody
    //http://localhost:8888/sys/addEmployee
    public Result addEmployee(EmployeeForm employeeForm){
        ValidatorUtil.validator(employeeForm);  //验证前端传入的数据

        Result result = employeeServiceImpl.add(employeeForm);
        return result;
    }

    @RequestMapping("/deleteByEmployeeId")
    @ResponseBody
    //http://localhost:8888/sys/deleteByEmployeeId
    public Result deleteByEmployeeId(Integer id){

        Result result = employeeServiceImpl.delete(id);
        return result;
    }

    @RequestMapping("/deleteByEmployeeIdList")
    @ResponseBody
    //http://localhost:8888/sys/deleteByEmployeeIdList
    public Result deleteByEmployeeIdList(Integer[] ids){
        System.out.println("+++++++++++++++++++++++++++++"+ JSON.toJSONString(ids));
        Result result = employeeServiceImpl.deleteByIdList(ids);
        return new Result();
    }

    @RequestMapping("/updateEmployee")
    @ResponseBody
    //http://localhost:8888/sys/updateEmployee
    public Result updateEmployee(EmployeeVO employeeVO){
        System.out.println(employeeVO);
        ValidatorUtil.validator(employeeVO);
        Result result = employeeServiceImpl.updateByPrimaryKeySelective(employeeVO);
        return result;
    }

    @RequestMapping("/exportExcel.do")
    @ResponseBody
    //http://localhost:8888/sys/exportExcel.do
    public void exportExcel(HttpServletResponse response, Integer[] ids){

        Result result = employeeServiceImpl.queryByIdList(ids);
        List<Object> listdata = (List<Object>) result.getData();

        EasyExcelUtil<EmployeeVO> excelUtil = new EasyExcelUtil<>();

        excelUtil.exportExcel(response, "员工表", EmployeeVO.class, listdata);
    }

    @RequestMapping("/importExcel.do")
    @ResponseBody
    //http://localhost:8888/sys/importExcel.do
    public Result importExcel(MultipartFile multipartFile){
        //新建easyexcel工具类，指定操作的实体类
        EasyExcelUtil<EmployeeVO> excelUtil = new EasyExcelUtil<>();

        EmployeeReadListener employeeReadListener = beanFactory.getBean(EmployeeReadListener.class);
        System.out.println(employeeReadListener.hashCode());
        Result result = excelUtil.importExcel(multipartFile, EmployeeVO.class, employeeReadListener);

        return result;
    }
}
