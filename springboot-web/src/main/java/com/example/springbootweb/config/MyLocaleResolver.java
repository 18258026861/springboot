package com.example.springbootweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author YZY
 * @date 2020/5/3 - 23:02
 */
@Configuration
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
//        获得语言切换的参数请求
        String language = request.getParameter("language");
//        默认
        Locale locale = Locale.getDefault();
//        如果携带了参数，就赋值返回
        if(!StringUtils.isEmpty(language))
        {
//            _分割：语言，国家
            String[] split = language.split("_");
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
