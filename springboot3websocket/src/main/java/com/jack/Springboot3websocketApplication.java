package com.jack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@SpringBootApplication
/**
 * 通过@EnableWebSocketMessageBroker注解开启使用STOMP协议来传输基于代理（message broker）的消息，这时控制器
 * 支持使用@MessageMapping，就像使用@RequestMapping一样
 */
//@EnableWebSocketMessageBroker
public class Springboot3websocketApplication /*extends AbstractWebSocketMessageBrokerConfigurer*/{

	public static void main(String[] args) {
		SpringApplication.run(Springboot3websocketApplication.class, args);
	}

	/**
	 * 注册STOMP协议的节点（endpoint），并映射的指定的URL
	 *
	 * @param stompEndpointRegistry
	 */
	/*@Override
	public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
		//注册一个STOMP的endpoint，并指定使用SockJS协议
		stompEndpointRegistry.addEndpoint("/endpointWisely").withSockJS();
	}*/

	/**
	 * 配置消息代理（MessageBroker）
	 * @param registry
	 */
	/*@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		//广播式应配置一个/topic消息代理
		registry.enableSimpleBroker("/topic");
	}*/
}
