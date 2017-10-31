package com.jack.springboot15activemq.controller;

import com.jack.springboot15activemq.msg.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by jack 2017/10/31
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @RequestMapping(value = "/sendMsg")
    public String sendMsg(){
        jmsTemplate.send("my-destination",new Msg());
        return "发送成功";
    }
}
