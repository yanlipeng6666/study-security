package com.itheima.security.springmvc.init;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Spring Security初始化，这里有两种情况
 * 1.若当前环境没有使用Spring或Spring MVC，则需要将 WebSecurityConfig(Spring Security配置类) 传入超 类，以确保获取配置，并创建spring context。
 * 2.相反，若当前环境已经使用spring，我们应该在现有的springContext中注册Spring Security(上一步已经做将 WebSecurityConfig加载至rootcontext)，此方法可以什么都不做。
 *
 * Program Name: security-itheima
 * Created by yanlp on 2021-01-09
 *
 * @author yanlp
 * @version 1.0
 */
public class SpringSecurityApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
    public SpringSecurityApplicationInitializer() {
        // 目前符合第二种情况,所以可以注释掉
        // super(WebSecurityConfig.class);
    }
}
