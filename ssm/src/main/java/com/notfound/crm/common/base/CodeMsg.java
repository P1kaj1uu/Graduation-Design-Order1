package com.notfound.crm.common.base;

/**
 * @Description:  枚举各种情况下的业务码和业务信息
 */
public enum CodeMsg {
    SUCCESS(200, "成功！"),
    ERROR(110, "失败！"),
    LOGIN_SUCCESS(110200,"登录成功！"),
    LOGIN_FAILD_WRONG_USERNAME(110404, "账户不存在"),
    LOGIN_FAILD_WRONG_PASSWORD(110405, "密码错误"),
    LOGIN_FAILD_WRONG_AUTHCODE(110406, "验证码错误");

    /**
     * 业务码
     */
    public Integer CODE;
    /**
     *  业务信息
     */
    public String MSG;

    CodeMsg(Integer code, String msg){
        this.CODE = code;
        this.MSG = msg;
    }

}
