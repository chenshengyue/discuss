package com.csy.discuss.core.order;

import com.csy.discuss.core.order.entity.CreateOrderRequest;

public interface OrderCreateTemplate {

    String orderType();

    void createOrder(CreateOrderRequest request);

}
