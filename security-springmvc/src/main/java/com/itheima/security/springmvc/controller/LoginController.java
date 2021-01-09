package com.itheima.security.springmvc.controller;

import com.itheima.security.springmvc.model.AuthenticationRequest;
import com.itheima.security.springmvc.model.UserDto;
import com.itheima.security.springmvc.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

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
    @PostMapping(value = "/login", produces = {"text/plain;charset=UTF-8"})
    public String login(AuthenticationRequest authenticationRequest, HttpSession session) {
        UserDto userDto = authenticationService.authentication(authenticationRequest);
        if (userDto != null) {
            session.setAttribute(UserDto.SESSION_USER_KEY, userDto);
        }
        return userDto.getFullname() + " 登录成功";
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @GetMapping(value = "/logout", produces = {"text/plain;charset=UTF-8"})
    public String logout(HttpSession session) {
        session.invalidate();
        return "登出成功";
    }

    @GetMapping(value = "/r/r1", produces = {"text/plain;charset=UTF-8"})
    public String r1(HttpSession session) {
        Object obj = session.getAttribute(UserDto.SESSION_USER_KEY);
        String fullName ;
        if (obj != null) {
            UserDto userDto = (UserDto) obj;
            fullName = userDto.getFullname();
        } else {
            fullName = "匿名.....";
        }
        return fullName + " 访问资源1";
    }


    @GetMapping(value = "/r/r2", produces = {"text/plain;charset=UTF-8"})
    public String r2(HttpSession session) {
        Object obj = session.getAttribute(UserDto.SESSION_USER_KEY);
        String fullName ;
        if (obj != null) {
            UserDto userDto = (UserDto) obj;
            fullName = userDto.getFullname();
        } else {
            fullName = "匿名.....";
        }
        return fullName + " 访问资源2";
    }


}
