package com.itheima.security.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Program Name: security-spring-security
 * Created by yanlp on 2021-01-09
 *
 * @author yanlp
 * @version 1.0
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 配置用户信息服务
     *
     * @return
     */
    // @Bean
    // @Override
    // public UserDetailsService userDetailsService() {
    //     InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    //     manager.createUser(User.withUsername("zhangsan").password("123").authorities("p1").build());
    //     manager.createUser(User.withUsername("lisi").password("456").authorities("p2").build());
    //
    //     return manager;
    // }

    /**
     * 密码编码器
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        // return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置安全拦截机制(最重要)
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()// 不再限制CSRF
                .authorizeRequests()
                .antMatchers("/r/r1").hasAnyAuthority("p1")//所有访问r/r1的请求,必须有p1权限
                .antMatchers("/r/r2").hasAnyAuthority("p2")//所有访问r/r2的请求,必须有p2权限
                .antMatchers("/r/**").authenticated()// 所有antMatchers表明的请求必须认证
                .anyRequest().permitAll()// 除了antMatchers,其他请求可以访问
                .and()
                .formLogin()// 允许表单登录
                .loginPage("/login-view")// 指定我们自己的登录页面,spring security以重定向方式跳转到/login
                .loginProcessingUrl("/login")// 指定登录处理的url,与login.jsp的action要对上,，也就是用户名、密码表单提交的目的路径
                .successForwardUrl("/login-success")// 自定义登录成功的页面地址,在Controller里有对应的路径请求
                 .permitAll();
    }
}
