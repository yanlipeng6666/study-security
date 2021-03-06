package com.itheima.security.springmvc.config;

import com.itheima.security.springmvc.interceptor.SimpleAuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Program Name: security-springmvc
 * Created by yanlp on 2021-01-08
 *
 * @author yanlp
 * @version 1.0
 */
@Configuration
@ComponentScan(basePackages = "com.itheima.security.springmvc",
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    SimpleAuthenticationInterceptor simpleAuthenticationInterceptor;

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 中新增如下配置，将/直接导向login.jsp页面.  貌似用自己tomcat起,不需要该配置
        // registry.addViewController("/").setViewName("login");
    }

    // @Override
    // public void addInterceptors(InterceptorRegistry registry) {
    //     // 增加拦截器,匹配下面资源为受保护的系统资源，访问该资源的请求进入
    //     // registry.addInterceptor(simpleAuthenticationInterceptor).addPathPatterns("/r/**");
    //     registry.addInterceptor(simpleAuthenticationInterceptor);
    // }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(simpleAuthenticationInterceptor).addPathPatterns("/r/**");
    }
}
