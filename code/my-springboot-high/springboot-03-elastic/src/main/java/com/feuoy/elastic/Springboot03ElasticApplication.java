package com.feuoy.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * <p>
 * <p>
 * SpringBoot默认支持两种技术来和ES交互
 * <p>
 * <p>
 * <p>
 * <p>
 * 1、【Jest（默认不生效）】
 * 【elasticsearch5.6.9对应jest依赖5.3.3】
 * 需要导入jest的工具包（io.searchbox.client.JestClient）（即maven依赖）
 * <p>
 * <p>
 * <p>
 * <p>
 * 2、【SpringData ElasticSearch】
 * 【springboot2.2对应ElasticSearch5.6.9】
 * ES版本有可能不合适；springboot2.0没有这个问题；如果版本不适配：2.4.6
 * 版本适配说明：https://github.com/spring-projects/spring-data-elasticsearch
 * <p>
 * 配置 Client 节点信息：clusterNodes, clusterName
 * <p>
 * 两种用法：https://github.com/spring-projects/spring-data-elasticsearch
 * 1）、ElasticsearchTemplate 可以操作es;
 * 2）、或编写一个 ElasticsearchRepository 的子接口来操作ES
 * <p>
 * <p>
 */


@SpringBootApplication
public class Springboot03ElasticApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03ElasticApplication.class, args);
    }

}
