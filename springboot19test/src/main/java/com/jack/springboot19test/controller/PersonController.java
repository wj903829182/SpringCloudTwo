package com.jack.springboot19test.controller;

import com.jack.springboot19test.dao.PersonRepository;
import com.jack.springboot19test.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * create by jack 2017/11/5
 */
@RestController
@RequestMapping("person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "findall",method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Person> findAll(){
        return personRepository.findAll();
    }

}
