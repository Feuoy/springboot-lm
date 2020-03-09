package com.feuoy.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;


@SpringBootTest
class Springboot04TaskApplicationTests {


    // 邮件发送者接口
    @Autowired
    JavaMailSenderImpl mailSender;


    @Test
    public void contextLoads() {

        // 简单消息邮件
        SimpleMailMessage message = new SimpleMailMessage();

        // 邮件设置
        message.setSubject("通知-今晚开会");
        message.setText("今晚7:30开会");

        // 收发
        message.setTo("feuoy@outlook.com");
        message.setFrom("994551034@qq.com");

        // 通过mailSender发送message
        mailSender.send(message);
    }


    @Test
    public void test02() throws  Exception{

        // 创建一个复杂消息邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        // 创建一个给mimeMessage的MimeMessageHelper
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setSubject("通知-今晚开会");

        // html格式
        helper.setText("<b style='color:red'>今天 7:30 开会</b>",true);

        helper.setTo("feuoy@outlook.com");
        helper.setFrom("994551034@qq.com");

        // 上传文件
        helper.addAttachment("1.jpg",new File("C:\\Users\\99455\\Desktop\\springboot\\myspringboot\\springboot-04-task\\src\\main\\resources\\static\\1.png"));

        mailSender.send(mimeMessage);
    }
}
