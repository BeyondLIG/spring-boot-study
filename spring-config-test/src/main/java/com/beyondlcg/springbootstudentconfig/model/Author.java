package com.beyondlcg.springbootstudentconfig.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: licg
 * @Date: 2019/1/21
 */
@Data
@Component
public class Author {
    @Value("${author.name}")
    private String name;

    @Value("${author.age}")
    private int age;
}