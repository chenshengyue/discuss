package com.csy.discuss.core.transaction;

import com.csy.discuss.core.dao.OrderMapper;
import com.csy.discuss.core.entity.Order;
import com.csy.discuss.core.exception.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private OrderMapper orderMapper;

    @Transactional
    @Override
    public void insertWithTransactional() {
        Order record = new Order();
        record.setUserId(1L);
        orderMapper.insertSelective(record);
    }

    @Transactional
    @Override
    public void insertThrowExceptionWithTransactional() {
        Order record = new Order();
        record.setUserId(1L);
        orderMapper.insertSelective(record);
        throw new BizException("TransactionService.insertThrowExceptionWithTransactional");

    }

    @Override
    public void insertThrowException() {
        Order record = new Order();
        record.setUserId(1L);
        orderMapper.insertSelective(record);
        throw new BizException("TransactionService.insertThrowException");

    }

    @Override
    public void insert() {
        Order record = new Order();
        record.setUserId(1L);
        orderMapper.insertSelective(record);
    }

}
