package com.jack.springboot14websocket.controller;

import com.alibaba.fastjson.JSONObject;
import com.jack.springboot14websocket.websockethandler.ChatMessageHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * create by jack 2017/10/25
 */
@RestController
@RequestMapping("test")
public class TestController {
    @RequestMapping(value = "/testSession")
    public JSONObject testSession(HttpServletRequest request, HttpServletResponse response){
        HttpSession  session = request.getSession();
        session.setAttribute("jack","my name is jack");
        Cookie[] cookie = request.getCookies();
        System.out.println("the cookie is : "+JSONObject.toJSON(cookie));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("session id is : ",session.getId());
        return jsonObject;
    }

    @RequestMapping(value = "/sendMsg")
    public JSONObject sendMsg(HttpServletRequest request, HttpServletResponse response){
        TextMessage message = new TextMessage("我是服务端的消息");
        System.out.println("size is : "+ChatMessageHandler.users.size());
        for (WebSocketSession user : ChatMessageHandler.users) {
            System.out.println(1);
            try {
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code","success");
        return jsonObject;
    }

}
