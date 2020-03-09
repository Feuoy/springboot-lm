package com.feuoy.springboot04.component;

import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


// 通过实现LocaleResolver，可以在链接上携带区域信息


public class MyLocaleResolver implements LocaleResolver {


    // 处理Locale问题
    @Override
    public Locale resolveLocale(HttpServletRequest request) {

        // 从request里面拿，语言选项参数l
        String l = request.getParameter("l");

        /*  按照源码中的参数需要，填进去就可以了
            public Locale(String language, String country) {
                this(language, country, "");
            }
        */

        // 先拿到默认的区域信息
        Locale locale = Locale.getDefault();

        // request的l不为空
        if (!StringUtils.isEmpty(l)) {

            // 会用"_"来做分割
            // String[]来存
            String[] split = l.split("_");

            // 填进去
            locale = new Locale(split[0], split[1]);
        }

        return locale;
    }


    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
    }


    // 构造函数
    // 无参返回一个这个类对象
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }


}