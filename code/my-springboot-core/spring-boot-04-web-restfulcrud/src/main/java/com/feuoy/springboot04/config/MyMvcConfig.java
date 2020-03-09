package com.feuoy.springboot04.config;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.feuoy.springboot04.component.LoginHandlerInterceptor;
import com.feuoy.springboot04.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// 使用WebMvcConfigurerAdapter（springboot2.0:WebMvcConfigurer）可以来扩展SpringMVC的功能


// @EnableWebMvc   注释掉，我们不要接管SpringMVC


@Configuration // 这是一个配置类


/*springboot1.0:public class MyMvcConfig extends WebMvcConfigurerAdapter {*/
public class MyMvcConfig implements WebMvcConfigurer {



    // 添加视图控制器，用ViewControllerRegistry
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // super.addViewControllers(registry);

        // 浏览器，发送/feuoy请求，那么是来到success
        // 访问http://localhost:8080/crud/feuoy，URL不变但用的是success的页面
        registry.addViewController("/feuoy").setViewName("success");
    }


    // 所有的WebMvcConfigurerAdapter（springboot2.0:WebMvcConfigurer）组件都会一起起作用


    //一定要，将组件注册在容器
    @Bean

/*springboot1.0:public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {*/
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer adapter = new WebMvcConfigurer() {

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {


                // 访问http://localhost:8080/crud/，页面为login
                registry.addViewController("/").setViewName("login");

                // 访问http://localhost:8080/crud/，页面为login
                registry.addViewController("/index.html").setViewName("login");


                registry.addViewController("/main.html").setViewName("dashboard");
            }


            // 注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                // super.addInterceptors(registry);

                // 关于静态资源：  *.css , *.js....    SpringBoot已经做好了静态资源映射

                // addPathPatterns("/**")：添加任意路径下的所有请求
                // excludePathPatterns("/index.html","/","/user/login")：除了index和/user/login

                // 在这里注释掉拦截器
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/index.html","/","/user/login");
            }
        };

        return adapter;
    }


    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }


}
