package com.jack.controller;

import com.jack.springboot.starter.hello.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootStarterController {

    @Autowired
    private HelloService helloService;
    @RequestMapping(value = "/start")
    public String start(){
        return helloService.sayHello();
    }
}
