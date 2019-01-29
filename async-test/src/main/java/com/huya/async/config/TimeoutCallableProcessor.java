package com.huya.async.config;


import com.huya.async.exception.CustomAsyncRequestTimeoutException;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.CallableProcessingInterceptor;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.Callable;

/**
 * @Author: licg
 * @Date: 2019/1/28
 * @Description：
 */
public class TimeoutCallableProcessor implements CallableProcessingInterceptor {
    @Override
    public <T> Object handleTimeout(NativeWebRequest request, Callable<T> task) throws Exception {
        HttpServletRequest httpServletRequest = request.getNativeRequest(HttpServletRequest.class);
        throw new CustomAsyncRequestTimeoutException(httpServletRequest.getRequestURI());
    }
}