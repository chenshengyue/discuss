package com.csy.discuss.core.autowire;

import org.springframework.stereotype.Service;

@Service
public class UserService2Impl implements UserService {

    @Override
    public void a() {
        System.out.println("UserService2Impl");
    }

}
