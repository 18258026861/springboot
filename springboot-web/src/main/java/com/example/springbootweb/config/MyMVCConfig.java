package com.example.springbootweb.config;

import com.example.springbootweb.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * @author YZY
 * @date 2020/5/3 - 17:18
 */
@Configuration
public class MyMVCConfig implements WebMvcConfigurer {
//    管理跳转链接，因为templates不允许外部访问
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
        registry.addViewController("/list.html").setViewName("list");
        registry.addViewController("/addE.html").setViewName("addE");
        registry.addViewController("/updateE.html").setViewName("updateE");
    }

//    自定义的国际化组件生效
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }


//添加自定义的拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//                                                          拦截全部请求，除了主页和登录请求,还有静态资源
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/login","/css/**","/img/**","/js/**");
    }


}
