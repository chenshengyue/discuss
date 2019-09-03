package com.csy.discuss.web;

import com.csy.discuss.core.listener.OrderStatusService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class ListenerApplication {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/listenerApplicationContext.xml");
        OrderStatusService orderStatusService = (OrderStatusService) context.getBean("orderStatusService");
        orderStatusService.updateStatus();
    }

}
