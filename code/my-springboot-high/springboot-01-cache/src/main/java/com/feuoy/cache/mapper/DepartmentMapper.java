/*缓存视频最后一节自定义cacheManage中，他讲解的是springboot1.x，在springboot2.x中弹幕说完全不一样，暂时放着*/
package com.feuoy.cache.mapper;

import com.feuoy.cache.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface DepartmentMapper {


    @Select("SELECT * FROM department WHERE id = #{id}")
    Department getDeptById(Integer id);


}
