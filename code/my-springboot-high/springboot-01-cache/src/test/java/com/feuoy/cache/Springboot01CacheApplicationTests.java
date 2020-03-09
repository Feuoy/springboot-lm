package com.feuoy.cache;

import com.feuoy.cache.bean.Employee;
import com.feuoy.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;


// 现在变成了这个，不用下面三个
import org.junit.jupiter.api.Test;


//import org.junit.Test;
//import org.junit.runner.RunWith;
//@RunWith(SpringRunner.class)


@SpringBootTest
class Springboot01CacheApplicationTests {


    /*测试springboot默认的cacheManager*/


    @Autowired
    EmployeeMapper employeeMapper;


    @Test
    public void contextLoads() {
        Employee empById = employeeMapper.getEmpById(1);
        System.out.println(empById);
    }



    /*测试redis的RedisCacheManager*/


    @Autowired
    StringRedisTemplate stringRedisTemplate;  //操作k-v都是字符串的

    @Autowired
    RedisTemplate redisTemplate;  //k-v都是对象的


    /**
     * Redis常见的五大数据类型：
     * String（字符串）、List（列表）、Set（集合）、Hash（散列）、ZSet（有序集合）
     * <p>
     * stringRedisTemplate.opsForValue()，[String（字符串）]
     * stringRedisTemplate.opsForList()，[List（列表）]
     * stringRedisTemplate.opsForSet()，[Set（集合）]
     * stringRedisTemplate.opsForHash()，[Hash（散列）]
     * stringRedisTemplate.opsForZSet()，[ZSet（有序集合）]
     */


    @Test
    public void test01() {
        // 给redis中保存数据
        stringRedisTemplate.opsForValue().append("msg","hello");

//		String msg = stringRedisTemplate.opsForValue().get("msg");
//		System.out.println(msg);

//        stringRedisTemplate.opsForList().leftPush("mylist", "1");
//        stringRedisTemplate.opsForList().leftPush("mylist", "2");
    }


    /*测试保存对象*/


    @Autowired
    RedisTemplate<Object, Employee> empRedisTemplate;


    @Test
    public void test02() {
        Employee empById = employeeMapper.getEmpById(1);
        System.out.println(empById);

//        // 如果保存对象，默认使用jdk序列化机制，序列化后的数据保存到redis中，不可读
//        redisTemplate.opsForValue().set("emp-01",empById);

        // 需要将数据以json的方式保存
        // (1)自己将对象转为json
        // (2)redisTemplate默认的序列化规则；改变默认的序列化规则；
        empRedisTemplate.opsForValue().set("emp-01", empById);
    }

}
