package com.csy.discuss.core.transaction;

public interface ParentTransactionService {

    void a();

    void insertWithTransactionalBeforeChild(Integer childType);

    void insertBeforeChild(Integer childType);

    void insertWithTransactionalAfterChild(Integer childType, Boolean exception);

    void insertAfterChild(Integer childType, Boolean exception);

}
