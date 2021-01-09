package com.itheima.security.springboot.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Program Name: security-itheima
 * Created by yanlp on 2021-01-09
 *
 * @author yanlp
 * @version 1.0
 */
@Service
public class SpringDataUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据账号去数据库查询...
        // 这里暂时使用静态数据 UserDetails userDetails
        System.out.println("用户名: " + username);

        UserDetails userDetails = User.withUsername("zhangsan").password("$2a$10$xJb1.nzYYqsXQ6oZuEewjuAFk1PwbqabC8Kc3fWvwY8fyYiMLaaDa").authorities("p1").build();

        return userDetails;
    }
}
