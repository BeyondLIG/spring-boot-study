package com.huya.springasynctest.controller;

import com.huya.springasynctest.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @Author: licg
 * @Date: 2019/1/28
 * @Description：
 */
@RestController
public class AsyncController {
    @Autowired
    private AsyncService asyncService;

    @GetMapping("/sync")
    public String doSync() throws InterruptedException {
        long start = System.currentTimeMillis();
        asyncService.syncEvent();
        long end = System.currentTimeMillis();
        return String.format("同步方法耗时：%d", end - start);
    }

    @GetMapping("/async")
    public String doAsync() throws InterruptedException {
        long start = System.currentTimeMillis();
        asyncService.asyncEvent();
        long end = System.currentTimeMillis();
        return String.format("异步方法耗时：%d", end - start);
    }

    @GetMapping("/async/callback")
    public String doAsyncWithCallBack() throws InterruptedException {
        long start = System.currentTimeMillis();
        Future<String> result = asyncService.asyncEventWithCallBack();
        while (true){
            if (result.isDone())
                break;
            Thread.sleep(100);
        }
        long end = System.currentTimeMillis();

        // 超时处理
//        get方法会一直阻塞，直到执行完成后才返回
//        get(long timeout, TimeUnit unit)在设置时间里未返回结果，会直接抛出TimeoutException异常
//        result.get(60, TimeUnit.SECONDS);
        return String.format("异步回调耗时：%d", end - start);
    }
}