package com.feuoy.springboot04.config;

import com.feuoy.springboot04.filter.MyFilter;
import com.feuoy.springboot04.listener.MyListener;
import com.feuoy.springboot04.servlet.MyServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;


// config包


@Configuration
public class MyServerConfig {


    // 注册三大组件
    // myServlet
    @Bean
    public ServletRegistrationBean myServlet() {

        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
        registrationBean.setLoadOnStartup(1);

        return registrationBean;
    }


    // myFilter
    @Bean
    public FilterRegistrationBean myFilter() {

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));

        return registrationBean;
    }


    // myListener
    @Bean
    public ServletListenerRegistrationBean myListener() {

        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());

        return registrationBean;
    }




    /*springboot1.5.10
    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.setPort(8083);
            }
        };
    }*/


    // springboot2.1.8
    // 配置嵌入式的Servlet容器
    @Bean   //一定要将这个定制器加入到容器中
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> embeddedServletContainerCustomizer() {

        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {

            // 定制嵌入式的Servlet容器相关的规则
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8080);
            }

        };
    }
}