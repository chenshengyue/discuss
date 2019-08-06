package com.csy.discuss.core.design.engine.impl;

import com.csy.discuss.core.design.engine.CreateOrderExecutor;
import com.csy.discuss.core.design.pipeline.context.CreateOrderContext;
import com.csy.discuss.core.design.pipeline.pipe.Pipe;
import com.csy.discuss.core.entity.Order;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class B2CEngineExecutor extends CreateOrderExecutor<Order, CreateOrderContext> {

    @Override
    public void afterPropertiesSet() {
        List<Pipe> pipeList = Lists.newArrayList();
        pipeList.add(addressPipe);
        pipeList.add(logisticPipe);
        pipeList.add(storePipe);
        pipeline.setPipeList(pipeList);
    }

    @Override
    public String name() {
        return "B2C";
    }

    @Override
    protected void validParameter(Order order) {

    }

    @Override
    protected void setKey(Order order, CreateOrderContext createOrderContext) {
        order.setOrderSn("2019031211111");
        createOrderContext.setKey(order.getOrderSn());
    }
}
