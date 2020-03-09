package com.feuoy.ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// WARNING: An illegal reflective access operation has occurred
// 警告，因为这个项目建的时候用的新建空项目，默认用的jdk11


/**
 * 【将服务提供者注册到注册中心】
 * 0、启动zookeeper
 * 1、引入dubbo和zkclient相关依赖
 * 2、配置dubbo的扫描包和注册中心地址
 * 3、使用dubbo的@Service发布服务
 */


@SpringBootApplication
public class ProviderTicketApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderTicketApplication.class, args);
    }

}






