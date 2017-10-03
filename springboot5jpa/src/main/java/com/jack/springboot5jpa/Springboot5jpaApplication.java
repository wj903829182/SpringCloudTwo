package com.jack.springboot5jpa;

import com.jack.springboot5jpa.pojo.CustomRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Springboot5jpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot5jpaApplication.class, args);
	}
}
