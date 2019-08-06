package com.csy.discuss.core.service.impl;

import com.csy.discuss.core.annotation.ServerCatch;
import com.csy.discuss.core.common.Result;
import com.csy.discuss.core.dao.OrderMapper;
import com.csy.discuss.core.entity.Order;
import com.csy.discuss.core.exception.BizException;
import com.csy.discuss.core.service.AopTestService;
import com.csy.discuss.core.service.OrderService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private AopTestService aopTestService;

    @Value("${test.a}")
    private String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @ServerCatch
    public Result<Boolean> aaa(Long id) {
        System.out.println(a);
        aopTestService.a();
        return Result.success(true);
    }

    public Result<Order> getById1(Long id) {
        OrderServiceImpl currentProxy = (OrderServiceImpl) AopContext.currentProxy();
        return currentProxy.getById(id);
//        return this.getById(id);
    }

    @ServerCatch
    public Result<Order> getById(Long id) {
        return Result.success(orderMapper.selectByPrimaryKey(id));
    }

    @Transactional
    public void insert(Order order) {
        orderMapper.insertSelective(order);
        if (true) {
            throw new BizException("111");
        }
    }

}
