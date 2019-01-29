package com.huya.async.controller;

import com.huya.async.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;

/**
 * User: licg
 * Date: 2019/1/9
 */
@RestController
public class WebAsyncTaskTestController {
    private static final Logger logger = LoggerFactory.getLogger(WebAsyncTaskTestController.class);

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/webAsyncTask")
    public WebAsyncTask<String> webAsyncTaskFunc() {
        logger.info(Thread.currentThread().getName() + "进入webAsyncTaskFunc方法");
        WebAsyncTask<String> webAsyncTask = new WebAsyncTask<>(3000, new Callable<String>() {
            @Override
            public String call() throws Exception {
                logger.info(Thread.currentThread().getName() + "进入call方法");
                String result = asyncService.asyncService();
                logger.info(Thread.currentThread().getName() + "从call方法返回");
                return result;
            }
        });
        logger.info(Thread.currentThread().getName() + "从webAsyncTaskFunc方法返回");

        webAsyncTask.onCompletion(new Runnable() {
            @Override
            public void run() {
                logger.info(Thread.currentThread().getName() + "进入run方法");
            }
        });
        webAsyncTask.onTimeout(new Callable<String>() {
            @Override
            public String call() throws Exception {
                logger.info(Thread.currentThread().getName() + "进入call方法");
                return "TimeOut";
            }
        });
        return webAsyncTask;
    }
}