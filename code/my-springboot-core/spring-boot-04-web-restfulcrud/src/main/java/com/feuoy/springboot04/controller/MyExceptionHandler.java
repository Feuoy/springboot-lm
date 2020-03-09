package com.feuoy.springboot04.controller;

import com.feuoy.springboot04.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


// 控制器建议注解
@ControllerAdvice


public class MyExceptionHandler {


/*    *//*1、
    浏览器、客户端返回的都是json
    没有自适应效果*//*
    @ResponseBody
    @ExceptionHandler(UserNotExistException.class)

    public Map<String,Object> handleException(Exception e){

        Map<String,Object> map = new HashMap<>();

        map.put("code","user.notexist");
        map.put("message",e.getMessage());

        return map;
    }*/




    /*2、
    转发到/error进行自适应响应效果处理*/
    @ExceptionHandler(UserNotExistException.class)

    public String handleException(Exception e, HttpServletRequest request){

        // 用HashMap放信息
        Map<String,Object> map = new HashMap<>();

        // request中带的状态码
        // Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");

        // 传入我们自己的错误状态码  4xx 5xx
        request.setAttribute("javax.servlet.error.status_code",500);

        // 其它信息
        map.put("code","user.notexist");
        map.put("message","用户出错啦");

        // 放进request
        request.setAttribute("ext",map);

        // 因为携带了消息，用转发
        // 转发到/error页面
        return "forward:/error";
    }
}
