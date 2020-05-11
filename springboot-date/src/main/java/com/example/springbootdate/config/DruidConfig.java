package com.example.springbootdate.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author YZY
 * @date 2020/5/6 - 21:56
 */
@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

//    后台监控
    @Bean
//    因为springboot内置了tomcat，所以没有web.xml， 用ServletRegistrationBean替代了这个功能
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

//        后台需要有人登陆
        HashMap<String, String> hashMap = new HashMap<>();
//          添加账号和密码  key的值固定不能变
        hashMap.put("loginUsername","admin");
        hashMap.put("loginPassword","123456");
//        允许谁可以访问
        hashMap.put("allow","");



        bean.setInitParameters(hashMap);
        return bean;
    }
}
