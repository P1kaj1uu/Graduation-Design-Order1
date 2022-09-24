package com.notfound.crm.common.handler;

import com.notfound.crm.common.base.CodeMsg;
import com.notfound.crm.common.base.Result;
import com.notfound.crm.common.exception.SystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:    这里是全局异常处理器
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理异常
     * @param exception
     * @return 返回异常信息
     */
    @ExceptionHandler
    @ResponseBody
    public Result bussiExceptionHandler(Exception exception){
        System.err.println(exception.getMessage());

        //判断是否是自定义的业务异常
        if(exception instanceof SystemException){
            SystemException sysTemException = (SystemException) exception;
            Result result = new Result();
            result.setCode(sysTemException.getCode());
            result.setMsg(sysTemException.getMsg());

            return result;
        }else {
            exception.printStackTrace();
        }
        return new Result(CodeMsg.ERROR);
    }
}
