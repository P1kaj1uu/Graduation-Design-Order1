package com.notfound.crm.common.base;

/**
 * @Description:  用来封装业务请求后的数据
 */
public class Result {
    /**
     * 业务码
     */
    private Integer code;
    /**
     * 业务信息
     */
    private String msg;
    /**
     * 业务数据
     */
    private Object data;

    /**
     * 正常没有数据时的返回结果
     */
    public Result(){
        this.code = CodeMsg.SUCCESS.CODE;
        this.msg = CodeMsg.SUCCESS.MSG;
    }
    /**
     * 发生异常时没有数据的返回结果
     */
    public Result(CodeMsg codeMsg){
        this.code = codeMsg.CODE;
        this.msg = codeMsg.MSG;
    }

    /**
     *  正常有数据时的返回结果
     * @param data
     */
    public Result(Object data){
        this();
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
