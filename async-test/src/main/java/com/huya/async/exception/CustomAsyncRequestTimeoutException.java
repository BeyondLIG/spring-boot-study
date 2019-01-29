package com.huya.async.exception;

/**
 * @Author: licg
 * @Date: 2019/1/28
 * @Description：自定义超时异常类
 */
public class CustomAsyncRequestTimeoutException extends RuntimeException {
    public CustomAsyncRequestTimeoutException(String uri) {
        super(uri);
    }
}