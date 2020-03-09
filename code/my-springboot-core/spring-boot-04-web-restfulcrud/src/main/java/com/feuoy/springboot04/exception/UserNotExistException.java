package com.feuoy.springboot04.exception;

// 继承运行时异常的用户不存在异常
public class UserNotExistException extends RuntimeException {

    // 无参构造一个提示
    public UserNotExistException() {
        super("用户不存在");
    }

}
