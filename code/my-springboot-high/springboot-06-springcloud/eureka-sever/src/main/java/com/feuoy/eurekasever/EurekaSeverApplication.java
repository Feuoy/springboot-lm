package com.feuoy.eurekasever;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * 注册中心（服务中心）
 * 1、配置Eureka信息
 * 2、@EnableEurekaServer
 */


@EnableEurekaServer


@SpringBootApplication
public class EurekaSeverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaSeverApplication.class, args);
	}

}
