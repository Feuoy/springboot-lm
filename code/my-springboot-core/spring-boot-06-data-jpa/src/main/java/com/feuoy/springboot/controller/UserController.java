package com.feuoy.springboot.controller;

import com.feuoy.springboot.entity.User;
import com.feuoy.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
public class UserController {


    @Autowired
    UserRepository userRepository;


    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
/*        // springboot1.x
        User user = userRepository.findOne(id);
        return user;*/

        // springboot2.x.
        User user = userRepository.findById(id).get();
        return user;
    }


    @GetMapping("/user")
    public User insertUser(User user){
        User save = userRepository.save(user);
        return save;
    }
}