package com.csy.discuss.core.dao;

import com.csy.discuss.core.entity.Order;

public interface OrderMapper {

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);
}