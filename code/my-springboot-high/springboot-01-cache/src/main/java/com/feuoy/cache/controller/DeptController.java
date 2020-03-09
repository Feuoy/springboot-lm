/*缓存视频最后一节自定义cacheManage中，他讲解的是springboot1.x，在springboot2.x中弹幕说完全不一样，暂时放着*/
package com.feuoy.cache.controller;

import com.feuoy.cache.bean.Department;
import com.feuoy.cache.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DeptController {


    @Autowired
    DeptService deptService;


    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id){
        return deptService.getDept(id);
    }
}
