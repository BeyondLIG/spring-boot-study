package com.huya.springasynctest.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @Author: licg
 * @Date: 2019/1/28
 * @Description：异步调用
 */
@Component
public class AsyncService {
    @Async("asyncPoolTaskExecutor")
    public void asyncEvent() throws InterruptedException {
        Thread.sleep(1000);
    }

    public void syncEvent() throws InterruptedException {
        Thread.sleep(1000);
    }

    @Async(value = "asyncPoolTaskExecutor")
    public Future<String> asyncEventWithCallBack() throws InterruptedException {
        Thread.sleep(1000);
        // AsyncResult是Spring提供的一个Future接口的子类
        return new AsyncResult<>("异步调用返回值");
    }

}