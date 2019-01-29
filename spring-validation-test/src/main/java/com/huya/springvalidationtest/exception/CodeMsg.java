package com.huya.springvalidationtest.exception;

/**
 * @Author: licg
 * @Date: 2019/1/28
 * @Description：异常枚举
 */
public enum  CodeMsg {
    PARAM_ERROR(400, "参数异常");

    int code;

    String msg;

    CodeMsg(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}