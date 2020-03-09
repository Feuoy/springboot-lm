package com.feuoy.springboot.repository;

import com.feuoy.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// 继承JpaRepository来完成对数据库的操作
// 写上对象类型<User,Integer>
public interface UserRepository
        extends JpaRepository<User,Integer> {
}