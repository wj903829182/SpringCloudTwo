package com.jack.springboot5jpa;

import com.jack.springboot5jpa.pojo.CustomRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
/**
 * 在配置类上配置@EnableJpaRepositories，并指定repositoryFactoryBeanClass，让我们自定义的Repository实现起效
 * 如果我们不需要自定义Repository实现，则在Spring Data JPA里无须添加@EnableJpaRepositories注解，因为
 * @SpringBootApplication包含的@EnableAutoConfiguration注解已经开启了对Spring Data JPA的支持
 */
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
public class Springboot5jpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot5jpaApplication.class, args);
	}
}
