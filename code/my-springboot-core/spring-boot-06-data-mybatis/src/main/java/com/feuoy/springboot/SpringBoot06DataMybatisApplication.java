package com.feuoy.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// 使用MapperScan批量扫描所有的Mapper接口
@MapperScan(value = "com.feuoy.springboot.mapper")


@SpringBootApplication
public class SpringBoot06DataMybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot06DataMybatisApplication.class, args);
    }
}
