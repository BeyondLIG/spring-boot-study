package com.beyondlcg.springscheduledtest.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * author: licg
 * email:  licgbeyond@foxmail.com
 * date:   2019/1/24
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduledTasksTest {
    @Autowired
    private ScheduledTasks scheduledTasks;

    @Test
    public void reportCurrentTime() {
        scheduledTasks.reportCurrentTime();
    }
}