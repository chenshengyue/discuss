package com.csy.discuss.core.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UniqueServiceImpl implements UniqueService {

    @Resource
    private UserService userService1Impl;

    @Autowired
    private UserService userService2Impl;

    @Value("${test.a}")
    private String a;

    @Override
    public void a() {
        userService2Impl.a();
    }
}
