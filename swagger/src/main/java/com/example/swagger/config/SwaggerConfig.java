package com.example.swagger.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.service.ApiInfo.DEFAULT_CONTACT;

/**
 * @author YZY
 * @date 2020/5/10 - 22:38
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Y1Y");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Y2Y");
    }

//    Swagger的bean实例Docket
    @Bean
    public Docket docket(@Qualifier("apiInfo") ApiInfo apiInfo,Environment environment){

//        设置swagger开启的环境
        Profiles dev = Profiles.of("dev");
//        获取当前项目的环境，判断swagger是否在开启的环境中
        boolean isdev = environment.acceptsProfiles(dev);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
//                关闭swagger   ，swagger-ui.html 就无法访问
                .enable(isdev)
                .groupName("YZY")
                .select()
                /*RequestHandlerSelector：配置要扫描的接口
                       basePackage:指定要扫描的包
                                   basePackage("com.example.swagger.controller") 扫描controller包里的接口
                       any: 所有接口
                       none：不扫描
                       withClassAnnotation 扫描类上的注解
                                   withClassAnnotation(RestController.class)  扫描有RestAonroller注解的类
                       withMethodAnnotation 扫描方法上的注解
                                   withMethodAnnotation(RequestMapping.class)  扫描有RequestMapping注解的方法*/
                .apis(RequestHandlerSelectors.basePackage("com.example.swagger.controller"))
                /*paths过滤路径（参数是需要的，过滤掉不需要的）
                *      PathSelector:路径选择器
                *           ant：路径
                            any:所有
                            none：都不      */
                .paths(PathSelectors.any())
                .build();
    }

//    设置一个Swagger apiInfo  ,覆盖了默认apiInfo
    @Bean
    public ApiInfo apiInfo(){
//      作者信息
        Contact contact = new Contact("YZY","http://localhost:8080/swagger-ui.html#/","1061603811@qq.com");

        return new ApiInfo("YZY的API文档",
                "文档描述",
                "1.1",
                "http://localhost:8080/swagger-ui.html#/", contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

}
