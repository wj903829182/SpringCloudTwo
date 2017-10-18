package com.jack.springboot12springsecurit.service;

import com.jack.springboot12springsecurit.dao.SysUserRepository;
import com.jack.springboot12springsecurit.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * create by jack 2017/10/18
 */

/**
 * 自定义需实现UserDetailsService接口
 */
public class CustomUserService implements UserDetailsService{
    @Autowired
    private SysUserRepository userRepository;

    /**
     * 重写loadUserByUsername方法获得用户
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        //我们当前的用户实现了UserDetails接口，可直接返回给Spring Security使用
        return user;
    }
}
