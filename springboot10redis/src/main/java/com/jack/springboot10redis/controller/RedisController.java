package com.jack.springboot10redis.controller;

import com.jack.springboot10redis.dao.PersonDao;
import com.jack.springboot10redis.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by jack 2017/10/11
 */
@RestController
@RequestMapping("redis")
public class RedisController {
    @Autowired
    private PersonDao personDao;

    /**
     * 演示设置字符及对象
     */
    @RequestMapping("/set")
    public void set(){
        Person person = new Person("1","jack",22);
        personDao.save(person);
        personDao.stringRedisTemplateDemo();
    }

    /**
     * 获得字符
     * @return
     */
    @RequestMapping("/getStr")
    public String getStr(){
        return personDao.getString();
    }

    /**
     * 获得对象
     * @return
     */
    @RequestMapping("/getPerson")
    public Person getPerson(){
        return personDao.getPerson();
    }


}
