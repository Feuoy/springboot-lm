package com.feuoy.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;




/**
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 一、搭建基本环境
 * 1、导入数据库文件，创建出department和employee表（sql）
 * 2、创建javaBean封装数据(bean)
 * 3、配置数据源信息(properties)
 * 4、整合注解版MyBatis操作数据库(mapper)
 * 5、添加@MapperScan指定需要扫描的mapper接口所在的包(SpringbootApplication)
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 二、快速体验缓存
 * 1、开启基于注解的缓存 @EnableCaching (SpringbootApplication)
 * 2、标注缓存注解即可 @Cacheable @CacheEvict @CachePut
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 默认使用的是ConcurrentMapCacheManager==ConcurrentMapCache；
 * 将数据保存在ConcurrentMap<Object, Object>中
 * 开发中使用缓存中间件；redis、memcached、ehcache；
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 三、整合redis作为缓存
 * Redis 是一个开源（BSD许可）的，内存中的数据结构存储系统，它可以用作数据库、缓存和消息中间件。
 * <p>
 * <p>
 * 1、安装redis：使用docker
 * 2、引入redis的starter（pom）
 * 3、配置redis(properties)
 * 4、测试缓存（文档：http://www.redis.cn/）
 * <p>
 * <p>
 * 【原理】：
 * CacheManager===Cache 缓存组件来实际给缓存中存取数据
 * 1）、引入redis的starter，容器中保存的是 RedisCacheManager；
 * 2）、RedisCacheManager 帮我们创建 RedisCache 来作为缓存组件；
 * 3）、RedisCache通过操作 redis 缓存数据
 * 4）、默认保存数据 k-v 都是Object；利用序列化保存；
 * <p>
 * <p>
 * 【如何保存为json】
 * 1、引入了redis的starter，cacheManager变为 RedisCacheManager；
 * 2、默认创建的 RedisCacheManager 操作redis的时候使用的是 RedisTemplate<Object, Object>
 * 3、RedisTemplate<Object, Object> 是默认使用jdk的序列化机制
 * 4、自定义CacheManager；
 */




@MapperScan("com.feuoy.cache.mapper")


@EnableCaching




@SpringBootApplication
public class Springboot01CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot01CacheApplication.class, args);
    }

}
