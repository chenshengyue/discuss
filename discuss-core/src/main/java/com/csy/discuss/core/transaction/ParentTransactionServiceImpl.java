package com.csy.discuss.core.transaction;

import com.csy.discuss.core.dao.OrderMapper;
import com.csy.discuss.core.entity.Order;
import com.csy.discuss.core.exception.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParentTransactionServiceImpl implements ParentTransactionService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private TransactionService transactionService;

    @Override
    public void a() {
        this.b();
    }

    @Override
    @Transactional
    public void b() {
        Order record = new Order();
        record.setUserId(1L);
        orderMapper.insertSelective(record);
//        throw new BizException("111");
    }

    @Transactional
    @Override
    public void insertWithTransactionalBeforeChild(Integer childType) {

        Order record = new Order();
        record.setUserId(1L);
        orderMapper.insertSelective(record);
        doChild(childType);

    }

    @Override
    public void insertBeforeChild(Integer childType) {

        Order record = new Order();
        record.setUserId(1L);
        orderMapper.insertSelective(record);
        doChild(childType);

    }

    @Transactional
    @Override
    public void insertWithTransactionalAfterChild(Integer childType, Boolean exception) {

        doChild(childType);

        Order record = new Order();
        record.setUserId(1L);
        orderMapper.insertSelective(record);
        if (Boolean.TRUE.equals(exception)) {
            throw new BizException("ParentTransactionService.insertWithTransactionalAfterChild");
        }

    }

    @Override
    public void insertAfterChild(Integer childType, Boolean exception) {

        doChild(childType);

        Order record = new Order();
        record.setUserId(1L);
        orderMapper.insertSelective(record);

        if (Boolean.TRUE.equals(exception)) {
            throw new BizException("ParentTransactionService.insertWithTransactionalAfterChild");
        }

    }

    private void doChild(Integer childType) {

        if (1 == childType) {
            transactionService.insertWithTransactional();
        }

        if (2 == childType) {
            transactionService.insertThrowExceptionWithTransactional();
        }

        if (3 == childType) {
            transactionService.insertThrowException();
        }

        if (4 == childType) {
            transactionService.insert();
        }

    }

}
