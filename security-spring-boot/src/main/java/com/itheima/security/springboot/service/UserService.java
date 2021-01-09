package com.itheima.security.springboot.service;

import com.itheima.security.springboot.dao.UserDao;
import com.itheima.security.springboot.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 此处为了方便,不使用接口注入了,直接用类注入
 * Program Name: security-itheima
 * Created by yanlp on 2021-01-09
 *
 * @author yanlp
 * @version 1.0
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    //根据账号查询用户信息
    public UserDto getUserByUsername(String username){
        return userDao.getUserByUsername(username);
    }
}
