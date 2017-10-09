package com.jack.springboot8cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Springboot8cacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot8cacheApplication.class, args);
	}
}
