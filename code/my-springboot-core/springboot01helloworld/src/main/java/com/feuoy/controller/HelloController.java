package com.feuoy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


// http://localhost:8080/hello


@Controller
public class HelloController {


    @ResponseBody  // 返回给浏览器
    @RequestMapping("/hello")   //  hello请求


    public String hello(){
        return "hello world";
    }
}
