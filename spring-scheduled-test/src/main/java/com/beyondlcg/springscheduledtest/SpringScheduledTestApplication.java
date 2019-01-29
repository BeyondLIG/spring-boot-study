package com.beyondlcg.springscheduledtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringScheduledTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringScheduledTestApplication.class, args);
    }

}

