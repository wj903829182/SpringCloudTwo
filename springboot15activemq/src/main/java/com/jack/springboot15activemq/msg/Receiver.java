package com.jack.springboot15activemq.msg;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * create by jack 2017/10/31
 */
@Component
public class Receiver {

    /**
     * @JmsListener是spring4.1为我们提供的一个新特性，用来简化JMS开发。我们只需在这个注解的属性destination指定
     * 要监听的目的地，即可接收该目的地发送的消息，下面监听的是my-destination
     * @param message
     */
    @JmsListener(destination = "my-destination")
    public void receiveMessage(String message){
        System.out.println("接收到：<"+message+">消息");
    }
}
