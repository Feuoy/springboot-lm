package com.feuoy.springboot04.controller;


import com.feuoy.springboot04.dao.DepartmentDao;
import com.feuoy.springboot04.dao.EmployeeDao;
import com.feuoy.springboot04.entities.Department;
import com.feuoy.springboot04.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


// controller层
@Controller


public class EmployeeController {


    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;


    // 查询所有员工，然后返回列表页面
    // GetMapping到/emps
    // 用Model放数据
    @GetMapping("/emps")
    public String list(Model model) {

        // 从employeeDao里面拿到
        // 用接口来声明
        Collection<Employee> employees = employeeDao.getAll();

        // 放在请求域中
        model.addAttribute("emps", employees);

        // thymeleaf会默认拼串
        // classpath:   /templates/xxxx.html
        return "emp/list";
    }


    // 来到员工添加页面，需要查询所有部门
    // GetMapping到/emp
    @GetMapping("/emp")
    public String toAddPage(Model model) {

        Collection<Department> departments = departmentDao.getDepartments();

        model.addAttribute("depts", departments);

        return "emp/add";
    }


    // 来到员工修改页面，需要查询当前员工，需要查询所有部门
    // GetMapping到/emp/{id}
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {

        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);

        // 回到修改页面（add是一个修改添加二合一的页面）
        return "emp/add";
    }


    // 员工修改，需要提交员工id
    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {

        System.out.println("修改的员工数据：" + employee);

        // employeeDao的save方法是添加和修改二合一
        employeeDao.save(employee);

        return "redirect:/emps";
    }


    // 员工删除
    // DeleteMapping到/emp/{id}
    // @PathVariable，获取路径变量参数
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }


    // 员工添加
    // PostMapping到/emp
    // SpringMVC自动将请求参数和入参对象的属性进行一一绑定
    // 要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/emp")
    public String addEmp(Employee employee) {

        System.out.println("保存的员工信息：" + employee);

        employeeDao.save(employee);

        // "/"代表当前项目路径，这里是http://localhost:8080/crud/
        // （暂时这样理解）因为不需要携带数据，那么用重定向
        // 重定向到emps，员工列表
        return "redirect:/emps";
    }


}