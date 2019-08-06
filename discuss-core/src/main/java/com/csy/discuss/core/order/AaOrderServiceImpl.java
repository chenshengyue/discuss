package com.csy.discuss.core.order;

import com.csy.discuss.core.order.entity.CreateOrderRequest;
import com.csy.discuss.core.order.entity.Order;
import org.springframework.stereotype.Service;

@Service("aaOrderService")
public class AaOrderServiceImpl extends AbstractOrderCreateTemplate implements OrderCreateTemplate {

    @Override
    public String orderType() {
        return "aa";
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
