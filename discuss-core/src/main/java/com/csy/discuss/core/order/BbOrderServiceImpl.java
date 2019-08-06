package com.csy.discuss.core.order;

import com.csy.discuss.core.order.entity.CreateOrderRequest;
import com.csy.discuss.core.order.entity.Order;
import org.springframework.stereotype.Service;

@Service("bbOrderService")
public class BbOrderServiceImpl extends AbstractOrderCreateTemplate implements OrderCreateTemplate {

    @Override
    public String orderType() {
        return "bb";
    }

    @Override
    public void createOrder(CreateOrderRequest request) {

        insertDB(request.getOrder(), request.getOrderItems());
    }

    @Override
    public void calculateAmount(Order order) {

    }

    @Override
    public void buildOrderItem(Order order) {

    }

}
