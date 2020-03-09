package com.feuoy.springboot.controller;



import com.feuoy.springboot.bean.Department;
import com.feuoy.springboot.bean.Employee;
import com.feuoy.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DeptController {


    @Autowired
    DepartmentMapper departmentMapper;  //  DepartmentMapper是一个接口，这里先不管

    // 对应/{id}
    // 记得加@PathVariable("id")
    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return departmentMapper.getDeptById(id);
    }


    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }


}
