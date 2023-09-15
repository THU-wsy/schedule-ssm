package com.thuwsy.ssm.config;

/**
 * ClassName: MapperJavaConfig
 * Package: com.thuwsy.ssm.config
 * Description:
 *
 * @Author THU_wsy
 * @Create 2023/9/15 14:37
 * @Version 1.0
 */

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
public class MapperJavaConfig {
    // 配置SqlSessionFactoryBean，这样就可以直接在IOC中获取SqlSessionFactory
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        //实例化SqlSessionFactory工厂
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);

        // 代替settings标签
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true); // 开启驼峰映射
        configuration.setLogImpl(Slf4jImpl.class); // 开启logback日志输出
        configuration.setAutoMappingBehavior(AutoMappingBehavior.FULL); // 开启resultMap自动映射
        sqlSessionFactoryBean.setConfiguration(configuration);

        // 代替typeAliases标签
        sqlSessionFactoryBean.setTypeAliasesPackage("com.thuwsy.ssm.pojo"); // 给实体类起别名

        // 分页插件配置
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        pageInterceptor.setProperties(properties);
        sqlSessionFactoryBean.addPlugins(pageInterceptor);

        return sqlSessionFactoryBean;
    }

    // 配置Mapper接口的扫描
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //设置mapper接口和mapper映射文件所在的共同包
        mapperScannerConfigurer.setBasePackage("com.thuwsy.ssm.mapper");
        return mapperScannerConfigurer;
    }
}
