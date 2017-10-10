package com.jack.springboot9mongodb.controller;

import com.jack.springboot9mongodb.dao.PersonRepository;
import com.jack.springboot9mongodb.entity.Location;
import com.jack.springboot9mongodb.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * create by jack 2017/10/10
 */
@RestController
@RequestMapping("mongo")
public class MongoDBController {
    @Autowired
    private PersonRepository personRepository;

    /**
     * 测试保存数据
     * @return
     */
    @RequestMapping("/save")
    public Person save(){
        Person p = new Person("jack2",20);
        Collection<Location> locations = new LinkedHashSet<>();
        Location loc1 = new Location("北京","2008");
        Location loc2 = new Location("上海","2009");
        Location loc3 = new Location("深圳","2010");
        Location loc4 = new Location("广州","2011");
        Location loc5 = new Location("杭州","2012");
        locations.add(loc1);
        locations.add(loc2);
        locations.add(loc3);
        locations.add(loc4);
        locations.add(loc5);
        p.setLocations(locations);
        return personRepository.save(p);
    }

    /**
     * 测试方法名查询
     * @param name
     * @return
     */
    @RequestMapping("/q1")
    public Person q1(String name){
        return personRepository.findByName(name);
    }

    /**
     * 测试@Query查询
     * @param age
     * @return
     */
    @RequestMapping("q2")
    public List<Person> q2(Integer age){
        return personRepository.withQueryFindByAge(age);
    }


}
