package com.thuwsy.ssm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * ClassName: ServiceJavaConfig
 * Package: com.thuwsy.ssm.config
 * Description:
 *
 * @Author THU_wsy
 * @Create 2023/9/15 14:21
 * @Version 1.0
 */
@Configuration
@EnableTransactionManagement // 开启声明式事务注解支持
@EnableAspectJAutoProxy // 开启aspect aop注解支持
@ComponentScan("com.thuwsy.ssm.service")
public class ServiceJavaConfig {
    @Bean // 装配事务管理器接口的实现类对象
    public TransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
