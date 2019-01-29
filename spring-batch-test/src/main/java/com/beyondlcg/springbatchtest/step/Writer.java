package com.beyondlcg.springbatchtest.step;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * @Author: licg
 * @Date: 2019/1/22
 */
public class Writer implements ItemWriter<String> {
    @Override
    public void write(List<? extends String> messages) throws Exception {
        for (String msg : messages) {
            System.out.println("Writing the data " + msg);
        }
    }
}