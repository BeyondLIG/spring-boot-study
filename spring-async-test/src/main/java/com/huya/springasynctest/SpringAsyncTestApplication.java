package com.huya.springasynctest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
// 启动异步调用
@EnableAsync
public class SpringAsyncTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAsyncTestApplication.class, args);
    }

}

