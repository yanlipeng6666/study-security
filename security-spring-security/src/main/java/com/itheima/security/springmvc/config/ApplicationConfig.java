package com.itheima.security.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * 在此配置除了Controller的其他bean,比如:数据库连接池 事务管理器 业务bean等
 * Program Name: security-springmvc
 * Created by yanlp on 2021-01-08
 *
 * @author yanlp
 * @version 1.0
 */
@Configuration
@ComponentScan(basePackages = "com.itheima.security.springmvc",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)}
)
public class ApplicationConfig {

}
