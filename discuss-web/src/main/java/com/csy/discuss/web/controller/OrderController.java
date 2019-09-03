package com.csy.discuss.web.controller;

import com.csy.discuss.core.common.Result;
import com.csy.discuss.core.design.engine.EngineExecutor;
import com.csy.discuss.core.design.engine.EngineResolver;
import com.csy.discuss.core.design.pipeline.context.CreateOrderContext;
import com.csy.discuss.core.entity.Order;
import com.csy.discuss.core.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

//    @Autowired
//    private OrderService orderService;
//
//    @Autowired
//    private EngineResolver engineResolver;
//
//    @GetMapping("/aaa")
//    public Result<Boolean> a(@RequestParam("id") Long id) {
//        return orderService.aaa(id);
//    }
//
//    @GetMapping("/getById1")
//    public Result<Order> getById1(@RequestParam("id") Long id) {
//        return orderService.getById1(id);
//    }
//
//    @GetMapping("/getById")
//    public Result<Order> getById(@RequestParam("id") Long id) {
//        return orderService.getById(id);
//    }
//
//    @PostMapping("/insert")
//    public Result<Boolean> insert(@RequestBody Order order) {
//        orderService.insert(order);
//        return Result.success(true);
//    }
//
//    @PostMapping("/checkOrder")
//    public Result<Boolean> checkOrder(@RequestBody Order order) throws Throwable {
//        EngineExecutor executor = engineResolver.getExecutor("checkOrder" + order.getOrderType());
//        if (executor == null) {
//            return Result.fail("订单来源错误");
//        }
//        return executor.execute(order, new CreateOrderContext());
//    }
//
//    @PostMapping("/createOrder")
//    public Result<Boolean> createOrder(@RequestBody Order order) throws Throwable {
//        EngineExecutor executor = engineResolver.getExecutor("createOrder_" + order.getOrderType());
//        if (executor == null) {
//            return Result.fail("订单来源错误");
//        }
//        return executor.execute(order, new CreateOrderContext());
//    }

}
