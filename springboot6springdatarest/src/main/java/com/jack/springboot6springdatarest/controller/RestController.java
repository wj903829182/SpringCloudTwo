package com.jack.springboot6springdatarest.controller;

import com.alibaba.fastjson.JSONObject;
import com.jack.springboot6springdatarest.dao.PersonRepository;
import com.jack.springboot6springdatarest.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * create by jack 2017/10/5
 */
/*@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
    @Autowired
    private PersonRepository personRepository;
    @RequestMapping(value = "/persons")
    public List<Person> persons(String name){
        List<Person> personList = personRepository.findByNameStartingWith(name);
        return personList;
    }
}*/
