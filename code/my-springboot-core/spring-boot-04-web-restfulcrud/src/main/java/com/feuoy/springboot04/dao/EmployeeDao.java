package com.feuoy.springboot04.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.feuoy.springboot04.entities.Department;
import com.feuoy.springboot04.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


// dao层
@Repository


public class EmployeeDao {


    // 预设的员工列表
    // static定义
    // map存
    // null初始
    // Map是接口
    private static Map<Integer, Employee> employees = null;


    // 静态代码块
    static {
        // HashMap是实现
        employees = new HashMap<Integer, Employee>();

        // HashMap的put方法放入
        employees.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1, new Department(101, "D-AA")));
        employees.put(1002, new Employee(1002, "E-BB", "bb@163.com", 1, new Department(102, "D-BB")));
        employees.put(1003, new Employee(1003, "E-CC", "cc@163.com", 0, new Department(103, "D-CC")));
        employees.put(1004, new Employee(1004, "E-DD", "dd@163.com", 0, new Department(104, "D-DD")));
        employees.put(1005, new Employee(1005, "E-EE", "ee@163.com", 1, new Department(105, "D-EE")));
    }


    // 自动注入
    @Autowired
    private DepartmentDao departmentDao;


    // 定义静态变量就行
    private static Integer initId = 1006;


    /*  查   */
    public Collection<Employee> getAll() {
        return employees.values();
    }

    public Employee get(Integer id) {
        return employees.get(id);
    }


    /*  删   */
    public void delete(Integer id) {
        employees.remove(id);
    }


    /*  增和改   */
    public void save(Employee employee) {

        // 通过id判断有无
        // 没有的话，给这个新员工set新id
        // 有的话，下面的employee.getId()就是原来的id，在那一条员工记录上set（传入的employee，在thymeleaf给controller的时候就已经构造好了数据）
        if (employee.getId() == null) {
            employee.setId(initId++);
        }

        // 通过get这个新员工id，传入departmentDao，返回department，set给这个新员工的department
        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));

        // 放<id, employee>
        employees.put(employee.getId(), employee);
    }
}
