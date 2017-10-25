package com.jack.springboot14websocket.config;

import com.jack.springboot14websocket.websockethandler.ChatHandshakeInterceptor;
import com.jack.springboot14websocket.websockethandler.ChatMessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * create by jack 2017/10/25
 * 参考：http://blog.csdn.net/zzhao114/article/details/60154017
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    /**
     * 这个类是配置类，第一个addHandler是对正常连接的配置，
     * 第二个是如果浏览器不支持websocket，使用socketjs模拟websocket的连接。
     * @param webSocketHandlerRegistry
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(chatMessageHandler(),"/webSocketServer").addInterceptors(new ChatHandshakeInterceptor());
        webSocketHandlerRegistry.addHandler(chatMessageHandler(), "/sockjs/webSocketServer").addInterceptors(new ChatHandshakeInterceptor()).withSockJS();
    }

    @Bean
    public TextWebSocketHandler chatMessageHandler(){
        return new ChatMessageHandler();
    }

}
