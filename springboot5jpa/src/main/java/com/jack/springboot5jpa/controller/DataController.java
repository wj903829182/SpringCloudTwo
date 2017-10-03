package com.jack.springboot5jpa.controller;

import com.jack.springboot5jpa.dao.PersonRepository;
import com.jack.springboot5jpa.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * create by jack 2017/10/3
 */
@RestController
@RequestMapping("/jpa")
public class DataController {
    /**
     * Spring Data JPA自动为我们注册了bean，所以可以自动注入
     */
    @Autowired
    private PersonRepository personRepository;
    /**
     * 保存
     * save支持批量保存
     * 删除；
     * 支持使用id删除对象，批量删除以及删除全部：
     * void delete(ID id);
     * void delete(T entity);
     * void delete(Iterable<? extends T> entities)
     * void deleteAll();
     */
    /**
     * 保存
     *
     * @param name
     * @param age
     * @param address
     * @return
     */
    @RequestMapping("/save")
    public Person save(String name, Integer age, String address) {
        Person person = personRepository.save(new Person(null, name, age, address));
        return person;
    }

    @RequestMapping("/q1")
    public List<Person> q1(String address) {
        List<Person> personList = personRepository.findByAddress(address);
        return personList;
    }

    /**
     * 测试findByNameAndAddress
     * @param name
     * @param address
     * @return
     */
    @RequestMapping("/q2")
    public Person q2(String name, String address) {
        Person person = personRepository.findByNameAndAddress(name, address);
        return person;
    }

    /**
     * 测试withNameAndAddressNamedQuery
     * @param name
     * @param address
     * @return
     */
    @RequestMapping("/q3")
    public Person q3(String name, String address) {
        Person person = personRepository.withNameAndAddressNamedQuery(name, address);
        return person;
    }

    /**
     * 测试withNameAndAddressNamedQuery
     * @param name
     * @param address
     * @return
     */
    @RequestMapping("/q4")
    public Person q4(String name, String address) {
        Person person = personRepository.withNameAndAddressNamedQuery(name, address);
        return person;
    }

    /**
     * 测试排序
     * @return
     */
    @RequestMapping("/sort")
    public List<Person> sort(){
        List<Person> personList = personRepository.findAll(new Sort(Sort.Direction.ASC,"age"));
        return personList;
    }

    /**
     * 测试分页
     * @return
     */
    @RequestMapping("/page")
    public Page<Person> page(){
        Page<Person> personPage = personRepository.findAll(new PageRequest(1,2));
        return personPage;
    }

}
