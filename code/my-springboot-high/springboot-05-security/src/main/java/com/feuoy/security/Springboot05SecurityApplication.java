package com.feuoy.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * <p>
 * <p>
 * 1、引入SpringSecurity；
 * <p>
 * <p>
 * 2、编写SpringSecurity的配置类；
 *
 * @EnableWebSecurity extends WebSecurityConfigurerAdapter
 * <p>
 * <p>
 * 3、控制请求的访问权限：
 * configure(HttpSecurity http) {
 * }
 * <p>
 * <p>
 * 4、定义认证规则：
 * configure(AuthenticationManagerBuilder auth){
 * }
 * <p>
 * <p>
 * 5、开启自动配置的登陆功能：
 * configure(HttpSecurity http){
 * http.formLogin();
 * }
 * <p>
 * <p>
 * 6、注销：
 * configure(HttpSecurity http){
 * http.logout();
 * }
 * <p>
 * <p>
 * 7、记住我：
 * configure(HttpSecurity http){
 * Remeberme()；
 * }
 * <p>
 * <p>
 */


@SpringBootApplication
public class Springboot05SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot05SecurityApplication.class, args);
    }

}
