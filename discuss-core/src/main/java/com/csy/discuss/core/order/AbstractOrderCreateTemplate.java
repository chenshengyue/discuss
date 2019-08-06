package com.csy.discuss.core.order;

import com.csy.discuss.core.order.entity.Order;
import com.csy.discuss.core.order.entity.OrderItem;

import java.util.List;

public abstract class AbstractOrderCreateTemplate {

    public void check(){
        System.out.println("AbstractOrderCreateTemplate.check");
    }

    public abstract void calculateAmount(Order order);

    public abstract void buildOrderItem(Order order);

    public void insertDB(Order order, List<OrderItem> orderItems) {
        System.out.println("AbstractOrderCreateTemplate.insertDB");
    }
}
