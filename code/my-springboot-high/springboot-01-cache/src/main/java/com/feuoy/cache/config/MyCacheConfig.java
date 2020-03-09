package com.feuoy.cache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;


/*自定义的KeyGenerator*/


@Configuration
public class MyCacheConfig {


    @Bean("myKeyGenerator")     // 这就放到组件了
    public KeyGenerator keyGenerator() {


        return new KeyGenerator() {


            @Override
            public Object generate(Object target, Method method, Object... params) {
                return method.getName() + "[" + Arrays.asList(params).toString() + "]";
            }
        };
    }
}