package com.feuoy.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity // 已经包含了@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {


        //super.configure(http);


        // 定制请求的授权规则
        // /，首页，所有人能访问
        // /level1/**，level1下所有页面，有VIP1角色的能访问
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");


        // 开启自动配置的登陆功能（/login），并定制（这里用/userlogin）
        http.formLogin()
                .usernameParameter("user").passwordParameter("pwd")
                .loginPage("/userlogin");
        // loginPage("/userlogin")，定制登录页
        // 用户名user和密码pwd参数，要对应userlogin.html
        // 访问 /userlogin 来到登陆页
        // 重定向到/userlogin?error表示登陆失败
        // get形式的 /userlogin代表到登录页，post形式的 /userlogin代表处理登录



        // 开启自动配置的注销功能
        http.logout()
                .logoutSuccessUrl("/");
        // 访问 /logout 表示用户注销，清空session
        // 注销成功以后来到/


        // 开启记住我功能
        http.rememberMe()
                .rememberMeParameter("remeber");
        // 记住我remeber参数，要对应userlogin.html
        // 登陆成功以后，将cookie发给浏览器保存，以后访问页面带上这个cookie，只要通过检查就可以免登录
        // 点击注销会删除cookie
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


//        //super.configure(auth);


        // 定义认证规则
        // 这里是在内存中保存认证
        // 用户zhangsan，密码123，有VIP1、VIP2的角色
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder()).withUser("zhangsan").password(new BCryptPasswordEncoder().encode("123")).roles("VIP1", "VIP2")
                .and()
                .passwordEncoder(new BCryptPasswordEncoder()).withUser("lisi").password(new BCryptPasswordEncoder().encode("123")).roles("VIP2", "VIP3")
                .and()
                .passwordEncoder(new BCryptPasswordEncoder()).withUser("wangwu").password(new BCryptPasswordEncoder().encode("123")).roles("VIP1", "VIP3");
    }
}
