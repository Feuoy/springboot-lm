package com.feuoy.springboot04.config;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 配置静态资源映射
 **/


@Component
public class MyResourceConfig implements WebMvcConfigurer {


    /**
     * 添加静态资源文件，外部可以直接访问地址
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {


        // http://localhost:8080/crud/static/asserts/js/bootstrap.min.js
        // classpath:/即resources
        // /**即该目录下所有文件
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/");
    }
}

