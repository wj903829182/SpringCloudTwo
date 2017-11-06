package com.jack.springboot20monitor;

import com.jack.springboot20monitor.endpoint.StatusEndpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Springboot20monitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot20monitorApplication.class, args);
	}


	@Bean
	public Endpoint<String> status(){
		Endpoint<String> status = new StatusEndpoint();
		return status;
	}

}
