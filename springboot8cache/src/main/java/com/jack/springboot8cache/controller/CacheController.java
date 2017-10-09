package com.jack.springboot8cache.controller;

import com.jack.springboot8cache.entity.Person;
import com.jack.springboot8cache.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by jack 2017/10/9
 */
@RestController
@RequestMapping("cache")
public class CacheController {
    @Autowired
    private DemoService demoService;

    @RequestMapping("/put")
    public Person put(Person person){
        return demoService.save(person);
    }

    @RequestMapping("/evit")
    public String evit(Integer id){
        demoService.remove(id);
        return "ok";
    }

    @RequestMapping("/cacheable")
    public Person cacheable(Person person){
        return demoService.findOne(person);
    }

}
