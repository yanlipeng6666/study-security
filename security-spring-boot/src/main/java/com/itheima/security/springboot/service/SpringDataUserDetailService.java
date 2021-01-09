package com.itheima.security.springboot.service;

import com.itheima.security.springboot.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据账号去数据库查询...
        // 这里暂时使用静态数据 UserDetails userDetails
        System.out.println("用户名: " + username);
        UserDto userDto = userService.getUserByUsername(username);
        if (userDto == null) {
            return null;
        }

        UserDetails userDetails = User.withUsername(userDto.getFullname()).password(userDto.getPassword()).authorities("p1").build();

        return userDetails;
    }
}
