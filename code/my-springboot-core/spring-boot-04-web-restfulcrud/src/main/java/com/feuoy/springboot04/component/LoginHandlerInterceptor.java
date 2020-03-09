package com.feuoy.springboot04.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// component包


// 拦截器，登陆检查，通过实现HandlerInterceptor


public class LoginHandlerInterceptor implements HandlerInterceptor {


    // 目标方法执行之前
    // request, response, handler
    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler)
            throws Exception {

        // Object一个user
        // 是request请求，session里面设置的loginUser
        Object user = request.getSession().getAttribute("loginUser");

        // 如果null
        if (user == null) {

            // 用request，放上消息提示msg
            request.setAttribute("msg", "没有权限，请先登录");

            // 获取请求转发器，转发器的指向通过getRequestDisPatcher()的参数
            // （暂时这样理解）因为带了数据，那么用转发
            // 转发到/index.html（这个请求会转到login.html），带上request和response
            request.getRequestDispatcher("/index.html").forward(request, response);

            // 返回false，这个目标方法执行不能放行
            return false;
        } else {

            // 已经登录，放行请求
            return true;
        }
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
