package com.jack.springboot16rabbitmq.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * create by jack 2017/11/1
 */
@Component
public class Receiver {

    /**
     * 使用@RabbitListener来监听RabbitMQ的目的地发送的消息，通过quues属性指定要监听的目的地
     * @param message
     */
    @RabbitListener(queues = "my-queue")
    public void receiveMessage(String message){
        System.out.println("received <"+message+" >");
    }
}
