package com.jack.springboot12springsecurit.config;

import com.jack.springboot12springsecurit.service.CustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * create by jack 2017/10/18
 */

/**
 * 扩展Spring Security配置需要继承WebSecurityConfigurerAdapter
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    /**
     * 注册CustomUserService的Bean
     * @return
     */
    @Bean
    UserDetailsService customUserService(){
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        /**
         * 添加我们自定义的user detail service认证
         */
        auth.userDetailsService(customUserService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.authorizeRequests()
                .anyRequest()
                .authenticated()//所有请求需要认证即登入后才能访问
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .permitAll()//定制登入行为，登入页面可任意访问
                .and()
                .logout()
                .permitAll();//定制注销行为，注销请求可任意访问
    }
}
