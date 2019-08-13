package com.csy.discuss.web.controller;

import com.csy.discuss.core.common.Result;
import com.csy.discuss.core.transaction.ParentTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private ParentTransactionService parentTransactionService;

    @GetMapping("/a")
    public Result<Boolean> a() {

        parentTransactionService.a();

        return Result.success();
    }

    @GetMapping("/b")
    public Result<Boolean> b() {

        parentTransactionService.b();

        return Result.success();
    }

    @GetMapping("/insertWithTransactionalBeforeChild")
    public Result<Boolean> insertWithTransactionalBeforeChild(@RequestParam(value = "type") Integer type) {

        parentTransactionService.insertWithTransactionalBeforeChild(type);

        return Result.success();
    }

    @GetMapping("/insertBeforeChild")
    public Result<Boolean> insertBeforeChild(@RequestParam(value = "type") Integer type) {

        parentTransactionService.insertBeforeChild(type);

        return Result.success();
    }

    @GetMapping("/insertWithTransactionalAfterChild")
    public Result<Boolean> insertWithTransactionalAfterChild(@RequestParam(value = "type") Integer type,
                                                             @RequestParam(required = false) Boolean exception) {

        parentTransactionService.insertWithTransactionalAfterChild(type, exception);

        return Result.success();
    }

    @GetMapping("/insertAfterChild")
    public Result<Boolean> insertAfterChild(@RequestParam(value = "type") Integer type,
                                            @RequestParam(required = false) Boolean exception) {

        parentTransactionService.insertAfterChild(type, exception);

        return Result.success();
    }
}
