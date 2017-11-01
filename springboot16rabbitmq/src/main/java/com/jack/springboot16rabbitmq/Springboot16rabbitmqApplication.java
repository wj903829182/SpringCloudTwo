package com.jack.springboot16rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springboot16rabbitmqApplication implements CommandLineRunner{

	/**
	 * 可注入spring boot为我们自动配置好的 RabbitTemplate
	 */
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Springboot16rabbitmqApplication.class, args);
	}

	/**
	 * 定义目的地即队列，队列名为my-queue
	 * @return
	 */
	@Bean
	public Queue wiselyQueue(){
		return new Queue("my-queue");
	}


	@Override
	public void run(String... strings) throws Exception {
		/**
		 * 通过RabbitTemplate的convertAndSend方法向队列my-queue发送消息
		 */
		rabbitTemplate.convertAndSend("my-queue","来自RabbitMQ发来的消息");
	}
}
