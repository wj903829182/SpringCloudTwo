package com.jack.springboot17dockerfile.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by jack 2017/11/3
 */
@RestController
@RequestMapping("docker")
public class DockerController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello world,docker";
    }
}
