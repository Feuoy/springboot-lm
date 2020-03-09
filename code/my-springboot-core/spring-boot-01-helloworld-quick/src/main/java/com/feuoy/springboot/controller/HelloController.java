package com.feuoy.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



//这个类的所有方法返回的数据直接写给浏览器，（如果是对象,转为json数据）
/*@ResponseBody
@Controller*/


// @ResponseBody和@Controller的合体
@RestController


public class HelloController {


    @RequestMapping("/hello")
    public String hello(){
        return "hello world quickly";
    }


}
