package com.feuoy.consumeruser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class UserController {


    @Autowired
    RestTemplate restTemplate;


    // http://127.0.0.1:8200/buy?name=张三
    // http://127.0.0.1:8200/buy?name=%E5%BC%A0%E4%B8%89


    @GetMapping("/buy")
    public String buyTicket(String name) {


        // 构造url去访问，返回Object(这里是String)
        String s = restTemplate.getForObject("http://PROVIDER-TICKET/ticket", String.class);


        return name + "购买了" + s;
    }
}
