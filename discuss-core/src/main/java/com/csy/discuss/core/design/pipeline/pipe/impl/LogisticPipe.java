package com.csy.discuss.core.design.pipeline.pipe.impl;

import com.alibaba.fastjson.JSON;
import com.csy.discuss.core.design.pipeline.InvocationChain;
import com.csy.discuss.core.design.pipeline.context.CreateOrderContext;
import com.csy.discuss.core.design.pipeline.pipe.AbstractPipe;
import com.csy.discuss.core.design.pipeline.rollback.RollBack;
import com.csy.discuss.core.entity.Order;
import com.csy.discuss.core.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("logisticPipe")
public class LogisticPipe extends AbstractPipe<Order, CreateOrderContext> implements RollBack<Order, CreateOrderContext> {

    @Override
    protected boolean isFilter(Order order, CreateOrderContext createOrderContext) {
        return false;
    }

    @Override
    protected void bizHandler(Order order, CreateOrderContext context) {
        log.info("do LogisticPipe biz");
        if (true) {
            throw new BizException("111");
        }
        context.setLogisticContext("bbb");
    }

    @Override
    public void rollBack(InvocationChain<Order, CreateOrderContext> invocationChain) {
        log.info("do LogisticPipe rollBack");
    }

}
