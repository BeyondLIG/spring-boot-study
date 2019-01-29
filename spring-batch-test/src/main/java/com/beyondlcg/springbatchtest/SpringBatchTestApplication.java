package com.beyondlcg.springbatchtest;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchTestApplication {

    // Spring Boot Batch 实战：https://www.jianshu.com/p/305192ea4cb1 https://www.xncoding.com/2017/08/01/spring/sb-batch.html
    public static void main(String[] args) {
        SpringApplication.run(SpringBatchTestApplication.class, args);
    }

}

