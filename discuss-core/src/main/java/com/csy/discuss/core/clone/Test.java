package com.csy.discuss.core.clone;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Order order1 = new Order();

        List<OrderItem> orderItems = Lists.newArrayList();
        order1.setId(1L);
        order1.setOrderItems(orderItems);
        orderItems.add(new OrderItem("1"));

        Order order2 = (Order) order1.deepClone();
        order2.setId(2L);
        order2.getOrderItems().get(0).setName("2");

        System.out.println(JSON.toJSONString(order1));
        System.out.println(JSON.toJSONString(order2));
    }
}
