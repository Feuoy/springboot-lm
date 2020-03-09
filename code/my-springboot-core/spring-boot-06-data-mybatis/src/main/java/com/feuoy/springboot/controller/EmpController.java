package com.feuoy.springboot.controller;



import com.feuoy.springboot.bean.Department;
import com.feuoy.springboot.bean.Employee;
import com.feuoy.springboot.mapper.DepartmentMapper;
import com.feuoy.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmpController {


    @Autowired
    EmployeeMapper employeeMapper;


    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
       return employeeMapper.getEmpById(id);
    }


}
