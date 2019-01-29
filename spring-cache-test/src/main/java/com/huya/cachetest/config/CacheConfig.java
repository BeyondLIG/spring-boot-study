package com.huya.cachetest.config;

import com.github.benmanes.caffeine.cache.CacheLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: licg
 * @Date: 2019/1/24
 * @Description：使用refreshAfterWrite配置需要指定一个CacheLoadeer
 */

@Configuration
public class CacheConfig {
    @Bean
    public CacheLoader<Object, Object> cacheLoader(){
        CacheLoader<Object, Object> cacheLoader = new CacheLoader<Object, Object>() {
            @Override
            public Object load(Object o) throws Exception {
                return null;
            }

            // 重写reload方法
            @Override
            public Object reload(Object key, Object oldValue) throws Exception {
                return oldValue;
            }
        };
        return cacheLoader;
    }
}