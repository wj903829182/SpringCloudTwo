package com.jack.controller;

import com.jack.pojo.WiselyMessage;
import com.jack.pojo.WiselyResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * websocket控制器
 */
@Controller
public class WsController {
    /**
     * 当浏览器向服务端发送请求时，通过@MessageMapping映射/welcome这个地址，类似于@RequestMapping
     * @param message
     * @return
     * @throws Exception
     */
    @MessageMapping("/welcome")
    /**
     * 当服务端有消息时，会对订阅了@SendTo中的路径的浏览器发送消息
     */
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message)throws  Exception{
        Thread.sleep(3000);
        return new WiselyResponse("Welcome," + message.getName() + "!");
    }
}
