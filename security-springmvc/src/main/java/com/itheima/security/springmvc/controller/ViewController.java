package com.itheima.security.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Program Name: security-springmvc
 * Created by yanlp on 2021-01-09
 *
 * @author yanlp
 * @version 1.0
 */
@Controller
@RequestMapping("/view")
public class ViewController {

    /**
     * 跳转页面
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }
}
