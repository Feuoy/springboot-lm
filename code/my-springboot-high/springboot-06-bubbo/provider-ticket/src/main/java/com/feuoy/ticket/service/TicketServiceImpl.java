package com.feuoy.ticket.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.stereotype.Component;


@EnableDubbo    // EnableDubbo


@Component  // 注册为一个组件


@Service    // dubbo的@Service，将服务发布出去


// 实现TicketService
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "《厉害了，我的国》";
    }
}
