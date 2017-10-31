package com.jack.springboot15activemq.msg;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * create by jack 2017/10/31
 * 定义JMS发送的消息需要实现MessageCreator接口，并重写其createMessage方法
 */
public class Msg implements MessageCreator {
    @Override
    public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage("测试消息");
    }
}
