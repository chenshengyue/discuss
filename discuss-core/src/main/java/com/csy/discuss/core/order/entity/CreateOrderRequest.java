package com.csy.discuss.core.order.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateOrderRequest {

    private Order order;

    private List<OrderItem> orderItems;

}
