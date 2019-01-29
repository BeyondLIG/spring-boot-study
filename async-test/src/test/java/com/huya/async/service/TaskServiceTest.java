package com.huya.async.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;


/**
 * author: licg
 * email:  licgbeyond@foxmail.com
 * date:   2019/1/24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceTest {
    @Autowired
    private TaskService taskService;

    @Test
    public void test() throws Exception {
        long start = System.currentTimeMillis();

        Future<String> task1 = taskService.doTaskOne();
        Future<String> task2 = taskService.doTaskTwo();
        Future<String> task3 = taskService.doTaskThree();

        while (true) {
            if (task1.isDone() && task2.isDone() && task3.isDone())
                break;
            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();

        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }
}