package com.itheima.security.springmvc.init;

import com.itheima.security.springmvc.config.ApplicationConfig;
import com.itheima.security.springmvc.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * spring容器初始化
 * Program Name: security-springmvc
 * Created by yanlp on 2021-01-08
 *
 * @author yanlp
 * @version 1.0
 */
public class SpringApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * spring容器,相当于加载 applicationContext.xml
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ApplicationConfig.class};
    }

    /**
     * servletContext,相当于加载springmvc.xml
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


}
