package com.huya.async.controller;

import com.huya.async.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * User: licg
 * Date: 2019/1/9
 */
@RestController
public class AsyncTestController {
    private static final Logger logger = LoggerFactory.getLogger(AsyncTestController.class);

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/syncFunc")
    public String syncFunc() {
        logger.info(Thread.currentThread().getName() + "进入syncFunc方法");
        return asyncService.asyncService();
    }


    @GetMapping("/asyncFunc")
    public Callable<String> asyncFunc() {
        logger.info(Thread.currentThread().getName() + "进入asyncFunc方法");
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                logger.info(Thread.currentThread().getName() + "进入call方法");
                String result = asyncService.asyncService();
                return result;
            }
        };
        logger.info(Thread.currentThread().getName() + "从asyncFunc方法返回");
        return callable;
    }
}