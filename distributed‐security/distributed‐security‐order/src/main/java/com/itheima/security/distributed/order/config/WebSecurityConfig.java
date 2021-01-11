package com.itheima.security.distributed.order.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Program Name: distributed‐security
 * Created by yanlp on 2021-01-11
 *
 * @author yanlp
 * @version 1.0
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                // .antMatchers("/r/r1").hasAuthority("p2")
                // .antMatchers("/r/r2").hasAuthority("p2")
                .antMatchers("/r/**").authenticated()// 所有/r/**的请求必须认证通过
                .anyRequest().permitAll()// 除了/r/**,其他的请求都可以访问

                ;
    }
}

