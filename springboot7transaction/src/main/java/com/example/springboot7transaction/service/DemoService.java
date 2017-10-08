package com.example.springboot7transaction.service;

import com.example.springboot7transaction.entity.Person;

/**
 * create by jack 2017/10/8
 * 服务接口
 */
public interface DemoService {
    Person savePersonWithRollBack(Person person);
    Person savePersonWithoutRollBack(Person person);
}
