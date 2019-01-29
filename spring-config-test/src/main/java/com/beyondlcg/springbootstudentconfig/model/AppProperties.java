package com.beyondlcg.springbootstudentconfig.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: licg
 * @Date: 2019/1/21
 */

@Data
@Component
@ConfigurationProperties(prefix = "author")
public class AppProperties {
    private String name;

    private int age;
}