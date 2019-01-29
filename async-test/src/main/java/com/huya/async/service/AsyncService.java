package com.huya.async.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * User: licg
 * Date: 2019/1/9
 */
@Service
public class AsyncService {
    private static final Logger logger = LoggerFactory.getLogger(AsyncService.class);

    public String asyncService() {
        logger.info(Thread.currentThread().getName() + "进入asyncService方法");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info(Thread.currentThread().getName() + "从asyncService方法返回");
        return "asyncService";
    }
}