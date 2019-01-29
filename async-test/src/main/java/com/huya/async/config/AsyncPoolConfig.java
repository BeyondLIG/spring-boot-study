package com.huya.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: licg
 * @Date: 2019/1/28
 * @Description：异步线程池
 */
@Configuration
public class AsyncPoolConfig extends WebMvcConfigurationSupport {
    /**
     * 配置线程池
     */
    @Bean(name = "asyncPoolTaskExecutor")
    public ThreadPoolTaskExecutor getAsyncThreadPoolTaskExecutor(){
        ThreadPoolTaskExecutor  taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(20);
        taskExecutor.setMaxPoolSize(200);
        taskExecutor.setQueueCapacity(25);
        taskExecutor.setKeepAliveSeconds(200);
        taskExecutor.setThreadNamePrefix("callable-");
        // 线程池对拒绝任务（无线程可用）的处理策略，目前只支持AbortPolicy、CallerRunsPolicy；默认为后者
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.initialize();
        return taskExecutor;
    }


    @Override
    protected void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        // 处理callable超时
        configurer.setDefaultTimeout(60 * 1000);
        // 注册超时拦截器
        configurer.registerCallableInterceptors(timeoutCallableProcessor());
        // 设置线程池
        configurer.setTaskExecutor(getAsyncThreadPoolTaskExecutor());
    }

    @Bean
    public TimeoutCallableProcessor timeoutCallableProcessor(){
        return new TimeoutCallableProcessor();
    }
}