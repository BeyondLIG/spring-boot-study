package com.huya.cachetest.service;

import com.huya.cachetest.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author: licg
 * @Date: 2019/1/24
 * @Description：
 */
@Service
public class PersonService {
    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

    // CachePut：主要应用于数据的写方法，如新增/修改数据，把方法返回的数据放入缓存
    // value：指定使用哪个缓存，key：缓存的键
    @CachePut(value = "people", key = "#person.id")
    public Person save(Person person){
        logger.info(String.format("缓存id为%d的Person", person.getId()));
        return person;
    }

    // CacheEvict：从缓存移除数据
    @CacheEvict(value = "people", key = "id")
    public void remove(long id){
        logger.info(String.format("删除id为%d的Person", id));
    }

    // Cacheable：主要应用于读取数据的方法，先从缓存读取数据，如果没有读取到，将返回的数据添加到缓存中
    @Cacheable(value = "person", key = "id")
    public Person findPerson(long id){
        Person person = new Person();
        person.setId(6);
        person.setName("Jack");
        logger.info(String.format("缓存id为%d的Person", id));
        return person;
    }
}