package com.feuoy.springboot04.controller;


import com.feuoy.springboot04.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;


@Controller
public class HelloController {


/*    // 两个请求都返回templates/index
    @RequestMapping({"/","/index.html"})
    public String index(){
        return "index"; // templates/
    }*/


/*    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }*/


/*    @ResponseBody
    @RequestMapping("/hello")
    public  String hello(@RequestParam("user") String user){
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "Hello World";
    }*/


    // http://localhost:8080/crud/success
    @RequestMapping("/success")
    public String success(Map<String, Object> map) {

        // k,v
        map.put("hello", "<h1>你好</h1>");

        // Arrays
        map.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));

        // templates/success.html
        return "success";
    }


}
