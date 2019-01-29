package com.beyondlcg.springbatchtest.config;

import com.beyondlcg.springbatchtest.listener.JobCompletedListener;
import com.beyondlcg.springbatchtest.step.Processor;
import com.beyondlcg.springbatchtest.step.Reader;
import com.beyondlcg.springbatchtest.step.Writer;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: licg
 * @Date: 2019/1/22
 */
@Configuration
public class BatchConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job processJob() {
        return jobBuilderFactory.get("processJob")
                .incrementer(new RunIdIncrementer()).listener(listener())
                .flow(orderStep()).end().build();
    }

    @Bean
    public Step orderStep() {
        return stepBuilderFactory.get("orderStep").<String, String>chunk(1)
                .reader(new Reader())
                .processor(new Processor())
                .writer(new Writer())
                .build();
    }

    @Bean
    public JobExecutionListener listener() {
        return new JobCompletedListener();
    }
}