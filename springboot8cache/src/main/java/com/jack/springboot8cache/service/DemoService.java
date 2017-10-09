package com.jack.springboot8cache.service;

import com.jack.springboot8cache.entity.Person;

/**
 * create by jack 2017/10/9
 */
public interface DemoService {
    Person save(Person person);

    void remove(Integer id);

    Person findOne(Person person);
}
