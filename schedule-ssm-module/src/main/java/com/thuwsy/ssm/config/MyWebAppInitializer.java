package com.thuwsy.ssm.config;

import jakarta.servlet.Filter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * ClassName: MyWebAppInitializer
 * Package: com.thuwsy.ssm.config
 * Description:
 *
 * @Author THU_wsy
 * @Create 2023/9/15 14:58
 * @Version 1.0
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override //指定root容器对应的配置类
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { MapperJavaConfig.class, ServiceJavaConfig.class, DataSourceJavaConfig.class };
    }
    @Override //指定web容器对应的配置类
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebJavaConfig.class };
    }
    @Override // 设置DispatcherServlet的处理路径，一般都用/处理所有请求
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override // 设置过滤器
    protected Filter[] getServletFilters() {
        // 创建编码过滤器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        // 创建处理请求方式的过滤器
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        return new Filter[]{characterEncodingFilter, hiddenHttpMethodFilter};
    }
}
