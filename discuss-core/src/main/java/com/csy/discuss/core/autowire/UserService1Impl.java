package com.csy.discuss.core.autowire;

import org.springframework.stereotype.Service;

//@Service("userService1")
@Service
public class UserService1Impl implements UserService {


    @Override
    public void a() {
        System.out.println("UserService1Impl");
    }

}
