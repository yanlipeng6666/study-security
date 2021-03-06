package com.itheima.security.springboot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
        return getUserName() + " 登录成功";
    }

    @RequestMapping(value = "/r/r1", produces = {"text/plain;charset=UTF-8"})
    @PreAuthorize("hasAuthority('p1')")// 拥有p1权限可以访问
    public String r1() {
        return getUserName() + "访问资源1";
    }

    @RequestMapping(value = "/r/r2", produces = {"text/plain;charset=UTF-8"})
    @PreAuthorize("hasAuthority('p2')")// 拥有p2权限可以访问
    public String r2() {
        return getUserName() + "访问资源2";
    }

    /**
     * 获取SpringSecurity的userName
     * @return
     */
    private String getUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        String username = "";
        if (principal == null) {
            username = "匿名";
        } else {
            if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) principal;
                username = userDetails.getUsername();
            } else {
                username = principal.toString();
            }
        }
        return username;
    }
}
