package com.csy.discuss.core.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class OrderStatusListener implements ApplicationListener<OrderStatusEvent> {

    @Override
    public void onApplicationEvent(OrderStatusEvent event) {

        if (event.getSource() instanceof UpdateOrderStatusBO) {

            System.out.println("success");

        }

    }

}
