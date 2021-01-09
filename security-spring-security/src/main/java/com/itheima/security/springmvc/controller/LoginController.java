package com.itheima.security.springmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录Controller
 * Program Name: security-itheima
 * Created by yanlp on 2021-01-09
 *
 * @author yanlp
 * @version 1.0
 */
@RestController
public class LoginController {

    @RequestMapping(value = "/login-success", produces = {"text/plain;charset=UTF-8"})
    public String loginSuccess() {
        return "登录成功";
    }
}
