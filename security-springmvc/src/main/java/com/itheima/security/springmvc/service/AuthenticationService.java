package com.itheima.security.springmvc.service;

import com.itheima.security.springmvc.model.AuthenticationRequest;
import com.itheima.security.springmvc.model.UserDto;

/**
 * Program Name: security-springmvc
 * Created by yanlp on 2021-01-09
 *
 * @author yanlp
 * @version 1.0
 */
public interface AuthenticationService {

    /**
     * 用户认证
     *
     * @param authenticationRequest 用户认证请求
     * @return认证成功的用户信息
     */
    UserDto authentication(AuthenticationRequest authenticationRequest);
}
