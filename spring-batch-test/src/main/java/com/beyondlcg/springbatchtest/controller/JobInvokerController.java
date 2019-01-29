package com.beyondlcg.springbatchtest.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: licg
 * @Date: 2019/1/22
 */
@RestController
public class JobInvokerController {
    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job processJob;

    @GetMapping("/invokeJob")
    public String handle() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(processJob, jobParameters);
        return "Batch job has been invoked";

    }
}