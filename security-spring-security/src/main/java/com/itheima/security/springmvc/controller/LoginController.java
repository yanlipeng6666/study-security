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

    /**
     * 登陆成功地址 ,要与WebSecurityConfig的configure方法的successForwardUrl对上
     * 默认登出地址,就是logout
     * @return
     */
    @RequestMapping(value = "/login-success", produces = {"text/plain;charset=UTF-8"})
    public String loginSuccess() {
        return "登录成功";
    }

    @RequestMapping(value = "/r/r1", produces = {"text/plain;charset=UTF-8"})
    public String r1() {
        return "访问资源1";
    }

    @RequestMapping(value = "/r/r2", produces = {"text/plain;charset=UTF-8"})
    public String r2() {
        return "访问资源2";
    }
}
