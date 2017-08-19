package com.jack.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.authorizeRequests()
                .antMatchers("/", "/login").permitAll()//设置Spring Security对/和/"login"路径拦截
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")//设置Spring Security的登入页面访问的路径为/login
                .defaultSuccessUrl("/chat")//登入成功后转向/chat路径
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    /**
     * 在内存中分配两个用户jack1和jack2，密码和用户名一样角色是USER
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth.inMemoryAuthentication()
                .withUser("jack1").
                password("jack1")
                .roles("USER")
                .and()
                .withUser("jack2")
                .password("jack2")
                .roles("USER");
    }

    /**
     * /resources/static/目录下的静态资源，Spring Security不拦截
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        //super.configure(web);
        web.ignoring().antMatchers("/resources/static/**");
    }
}
