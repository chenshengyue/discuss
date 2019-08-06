package com.csy.discuss.core.order;

import com.csy.discuss.core.order.entity.CreateOrderRequest;

public class OrderCreateService {

    private OrderCreateResolver orderCreateResolver;

    public void create(CreateOrderRequest request) {
        OrderCreateTemplate template = orderCreateResolver.getHandler(request.getOrder().getOrderType());
        template.createOrder(request);
    }

}
