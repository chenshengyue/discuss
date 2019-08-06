package com.csy.discuss.core.service;

import com.csy.discuss.core.common.Result;
import com.csy.discuss.core.entity.Order;

public interface OrderService {

    Result<Boolean> aaa(Long id);

    Result<Order> getById1(Long id);

    Result<Order> getById(Long id);

    void insert(Order order);
}
