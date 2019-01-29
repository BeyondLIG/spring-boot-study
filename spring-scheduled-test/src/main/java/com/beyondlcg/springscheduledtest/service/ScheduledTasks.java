package com.beyondlcg.springscheduledtest.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: licg
 * @Date: 2019/1/24
 * @Description：
 */

@Component
public class ScheduledTasks {
    private static final SimpleDateFormat db = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 3000)
    public void reportCurrentTime(){
        System.out.println(db.format(new Date()));
    }
}