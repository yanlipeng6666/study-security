package com.itheima.security.springmvc.controller;

import com.itheima.security.springmvc.model.AuthenticationRequest;
import com.itheima.security.springmvc.model.UserDto;
import com.itheima.security.springmvc.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Program Name: security-springmvc
 * Created by yanlp on 2021-01-08
 *
 * @author yanlp
 * @version 1.0
 */
@RestController
public class LoginController {
    @Autowired
    private AuthenticationService authenticationService;

    /**
     * 登录
     *
     * @return
     */
    @PostMapping(value = "/login",produces = {"text/plain;charset=UTF-8"})
    public String login( AuthenticationRequest authenticationRequest) {
        UserDto userDto = authenticationService.authentication(authenticationRequest);
        return userDto.getFullname() + " 登录成功";
    }

}
