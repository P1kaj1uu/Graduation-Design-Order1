package com.notfound.crm.sys.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.notfound.crm.common.base.Constant;
import com.notfound.crm.common.base.Result;
import com.notfound.crm.common.exception.SystemException;
import com.notfound.crm.sys.mapper.EmployeeMapper;
import com.sun.net.httpserver.HttpContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @Description: 这里是员工类的拦截器
 */
public class MyInterceptor implements HandlerInterceptor {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("请求路径为："+request.getRequestURI());
        System.out.println("获取的cookies："+request.getCookies());
        System.out.println("SessionId的值为:"+request.getSession().getId());

//        System.out.println(request.getHeader("authorization"));
        if(request.getSession().getAttribute("CURR_USER") != null){ //验证是否登录，如果为空，则用户未登录
            //获取用户权限列表
            List<String> role_list = (List<String>) request.getSession().getAttribute("ROLE_LIST");
//            System.out.println("权限列表中的某个值："+role_list.get(36));
            System.out.println("拦截器中的权限:"+role_list);
            if(role_list != null && role_list.contains(request.getRequestURI())){   //判断用户访问的接口有无权限
                return true;
            }else {
                throw new SystemException(Constant.HAVE_NO_LEGAL_POWER, "你没有相应权限，不能进行该操作！");
            }
        }else {
            throw new SystemException(Constant.NOT_LOGGED_IN, "未登录，请先登录账号！");
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
