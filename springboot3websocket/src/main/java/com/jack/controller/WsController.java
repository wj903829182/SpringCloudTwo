package com.jack.controller;

import com.jack.pojo.WiselyMessage;
import com.jack.pojo.WiselyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * websocket控制器
 */
@Controller
public class WsController {
    /**
     * 通过SimpMessagingTemplate向浏览器发送消息
     */
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    /**
     * 当浏览器向服务端发送请求时，通过@MessageMapping映射/welcome这个地址，类似于@RequestMapping
     *
     * @param message
     * @return
     * @throws Exception
     */
    @MessageMapping("/welcome")
    /**
     * 当服务端有消息时，会对订阅了@SendTo中的路径的浏览器发送消息
     */
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message) throws Exception {
        Thread.sleep(3000);
        return new WiselyResponse("Welcome," + message.getName() + "!");
    }

    /**
     * 在Spring MVC，可以直接在参数中获得principal，pinciple中包含当前用户的的信息
     *
     * @param principal
     * @param msg
     */
    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) {
        /**
         * 下面是一段硬编码，如果发送人是jack1则发送给jack2，如果发送人是jack2则发送给jack1，
         * 可以根据项目实际需要编写此处代码
         */
        if (principal.getName().equals("jack1")) {
            /**
             * 通过 messagingTemplate.convertAndSendToUser向用户发送消息，第一个参数是接收消息的用户，
             * 第二个是浏览器订阅的地址，第三个是消息本身
             */
            messagingTemplate.convertAndSendToUser("jack2",
                    "/queue/notifications",
                    principal.getName() + "-send:" + msg);
        }else {
            messagingTemplate.convertAndSendToUser("jack1",
                    "/queue/notifications",principal.getName()+"-send:"+msg);
        }
    }

}
