package com.feuoy.springboot04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
public class LoginController {


//    @DeleteMapping, @PutMapping, @GetMapping, @PostMapping的请求
//    相当于@RequestMapping(value = "/user/login", method = RequestMethod.POST)


    // PostMapping到/user/login
    // @RequestParam，请求的参数
    // HttpSession，可以放需要的session
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map,
                        HttpSession session) {

        if (!StringUtils.isEmpty(username) && "123".equals(password)) {

            // 放用户数据到session
            session.setAttribute("loginUser", username);

            // 登录成功，未来防止表单重复提交，可以重定向到主页（这个请求会转到dashboard.html，就是主页）
            return "redirect:/main.html";

        } else {
            // 登录失败
            map.put("msg", "用户名或密码错误");
            return "login";
        }
    }


}
