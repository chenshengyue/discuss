package com.csy.discuss.core.transaction;

public interface TransactionService {

    void insertWithTransactional();

    void insertThrowExceptionWithTransactional();

    void insertThrowException();

}
