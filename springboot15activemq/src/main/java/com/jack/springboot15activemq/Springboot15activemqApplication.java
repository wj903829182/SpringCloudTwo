package com.jack.springboot15activemq;

import com.jack.springboot15activemq.msg.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
/**
 * spring boot为我们提供了CommandLineRunner接口，用于程序启动后执行的代码，通过重写其run方法执行
 */
public class Springboot15activemqApplication implements CommandLineRunner{

	/**
	 * 注入spring boot为我们配置好的JmsTemplate的Bean
	 */
	@Autowired
	private JmsTemplate jmsTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Springboot15activemqApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		/**
		 * 通过JmsTemplate的send方法向my-destination目的地发送Msg的消息，这里也等于在消息代理
		 * 上定义了一个目的地叫my-destination
		 */
		jmsTemplate.send("my-destination",new Msg());
	}
}
