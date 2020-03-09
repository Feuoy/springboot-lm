package com.feuoy.user.service;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.feuoy.ticket.service.TicketService;
import org.springframework.stereotype.Service;


// 客户端也是EnableDubbo的；一定要加这个，网友们的集体经验
@EnableDubbo


// 这个是spring的@Service
@Service
public class UserService {


    // 引用这个项目下可以请求的TicketService
    @Reference
    TicketService ticketService;


    // 就可以使用服务端的服务了
    public void hello(){
        String ticket = ticketService.getTicket();
        System.out.println("买到票了："+ticket);
    }


}
