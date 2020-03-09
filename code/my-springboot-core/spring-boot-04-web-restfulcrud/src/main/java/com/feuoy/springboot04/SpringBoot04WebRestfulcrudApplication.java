package com.feuoy.springboot04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.View;

import java.util.Locale;


// http://localhost:8080/crud/


@SpringBootApplication


// SpringBoot04WebRestfulcrud，加Application
public class SpringBoot04WebRestfulcrudApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringBoot04WebRestfulcrudApplication.class, args);
    }





    /*// do not know
    public static class MyViewResolver implements ViewResolver {
        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }

    @Bean
    public ViewResolver myViewResolver() {
        return new MyViewResolver();
    }*/


}
