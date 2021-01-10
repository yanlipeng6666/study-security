package com.itheima.security.springboot.service;

import com.itheima.security.springboot.dao.UserDao;
import com.itheima.security.springboot.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Program Name: security-itheima
 * Created by yanlp on 2021-01-09
 *
 * @author yanlp
 * @version 1.0
 */
@Service
public class SpringDataUserDetailService implements UserDetailsService {
    /**
     * 简单起见,直接注入dao了
     */
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据账号去数据库查询...
        // 这里暂时使用静态数据 UserDetails userDetails
        System.out.println("用户名: " + username);
        UserDto userDto = userDao.getUserByUsername(username);
        if (userDto == null) {
            return null;
        }

        List<String> permissionCodeList =  userDao.getPermissionCodeByUserId(userDto.getId());
        String[] authorties = new String[permissionCodeList.size()];
        permissionCodeList.toArray(authorties);

        UserDetails userDetails = User.withUsername(userDto.getFullname()).password(userDto.getPassword()).authorities(authorties).build();

        return userDetails;
    }
}
