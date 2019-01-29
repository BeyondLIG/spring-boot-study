package com.beyondlcg.springbatchtest.step;

import org.springframework.batch.item.ItemProcessor;

/**
 * @Author: licg
 * @Date: 2019/1/22
 */
public class Processor implements ItemProcessor<String, String> {
    @Override
    public String process(String s) throws Exception {
        return s.toUpperCase();
    }
}