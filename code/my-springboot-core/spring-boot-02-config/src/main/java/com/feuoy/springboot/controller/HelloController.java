package com.feuoy.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.awt.SunHints;


@ResponseBody
@Controller


public class HelloController {


    @Value("${person.last-name}")
    private String name;


    @RequestMapping("/sayHello")
    public String sayHello(){
        return "Hello " + name;
    }
}
