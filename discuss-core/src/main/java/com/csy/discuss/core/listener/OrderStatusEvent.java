package com.csy.discuss.core.listener;

import org.springframework.context.ApplicationEvent;

public class OrderStatusEvent extends ApplicationEvent {

    public OrderStatusEvent(UpdateOrderStatusBO source) {
        super(source);
    }

}
