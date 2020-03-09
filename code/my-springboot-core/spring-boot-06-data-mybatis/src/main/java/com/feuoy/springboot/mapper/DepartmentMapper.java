package com.feuoy.springboot.mapper;

import com.feuoy.springboot.bean.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;


// 指定这是一个操作数据库的mapper
// @Mapper或@MapperScan将接口扫描装配到容器中
@Mapper


public interface DepartmentMapper {


    // #{id}
    // Integer id
    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    @Update("update department set department_name=#{departmentName} where id=#{id}")
    public int updateDept(Department department);


    // 使用自动生成的健
    @Options(useGeneratedKeys = true, keyProperty = "id")

    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDept(Department department);
}