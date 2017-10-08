package com.example.springboot7transaction.impl;

import com.example.springboot7transaction.dao.PersonRepository;
import com.example.springboot7transaction.entity.Person;
import com.example.springboot7transaction.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * create by jack 2017/10/8
 */
@Service
public class DemoServiceImpl implements DemoService{
    /**
     * 直接注入我们的PersonRepository
     */
    @Autowired
    private PersonRepository personRepository;

    /**
     * 使用@Transactional注解的rollbackFor属性，指定特定异常时，数据回滚
     * @param person
     * @return
     */
    @Transactional(rollbackFor = {IllegalArgumentException.class})
    @Override
    public Person savePersonWithRollBack(Person person) {
        Person p = personRepository.save(person);
        if (person.getName().equals("jack7")) {
            //抛出异常
            throw new IllegalArgumentException("jack7已存在，数据将回滚");
        }
        return p;
    }

    /**
     * 使用@Transactional注解的noRollbackFor属性，指定特定异常时，数据不回滚
     * @param person
     * @return
     */
    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    @Override
    public Person savePersonWithoutRollBack(Person person) {
        Person p = personRepository.save(person);
        if ("jack7".equals(person.getName())) {
            //抛出异常
            throw new IllegalArgumentException("jack7已存在，数据将不会回滚");
        }
        return p;
    }
}
