package com.beyondlcg.springbootstudentconfig.controller;

import com.beyondlcg.springbootstudentconfig.model.AppProperties;
import com.beyondlcg.springbootstudentconfig.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: licg
 * @Date: 2019/1/21
 */

@RestController
public class PropertiesController {
    @Autowired
    private AppProperties appProperties;

    @Autowired
    private Author author;

    @GetMapping("/")
    public String index() {
        return appProperties.getName();
    }

    @GetMapping("/index")
    public String authorIndex() {
        return author.getName();
    }
}