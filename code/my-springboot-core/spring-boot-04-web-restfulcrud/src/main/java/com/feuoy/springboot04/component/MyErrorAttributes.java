package com.feuoy.springboot04.component;

//import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import java.util.Map;


// 给容器中加入我们自己定义的ErrorAttributes组件
@Component


public class MyErrorAttributes extends DefaultErrorAttributes {


    /*springboot1.5.10@Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(requestAttributes, includeStackTrace);
        map.put("company","atguigu");
        Map<String,Object> ext = (Map<String, Object>) requestAttributes.getAttribute("ext", 0);
        map.put("ext",ext);
        return map;
    }*/


    /*springboot2.1.8*/
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {

        /* 先放继承的DefaultErrorAttributes的信息，包括
         * <ul>
         * <li>timestamp - The time that the errors were extracted</li>
         * <li>status - The status code</li>
         * <li>error - The error reason</li>
         * <li>exception - The class name of the root exception (if configured)</li>
         * <li>message - The exception message</li>
         * <li>errors - Any {@link ObjectError}s from a {@link BindingResult} exception
         * <li>trace - The exception stack trace</li>
         * <li>path - The URL path when the exception was raised</li>
         * </ul>
         */
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);

        // 再加入我们自己的map信息
        // 自定义公司信息company
        map.put("company", "feuoy");

        // 我们的异常处理器携带的数据ext
        Map<String, Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
        map.put("ext", ext);

        // 返回值的map就是浏览器页面和json能获取的所有字段
        return map;
    }
}