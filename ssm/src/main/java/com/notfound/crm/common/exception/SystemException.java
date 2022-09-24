package com.notfound.crm.common.exception;

/**
 * @Description: 这里是员工类的controller，端口访问
 */
/**
 * 业务异常类
 * 当程序出现异常时，抛出异常信息
 * 1.数据校验不通过时
 * 2.当数据操作出现异常时，抛出异常信息，数据回滚
 */
public class SystemException extends RuntimeException {

    /**
     * 异常编码
     */
    private Integer code;
    /**
     * 异常信息
     */
    private String msg;

    public SystemException(){}

    public SystemException(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
