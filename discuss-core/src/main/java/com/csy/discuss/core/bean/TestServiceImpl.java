package com.csy.discuss.core.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService, ApplicationContextAware, ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserService userService1;

    @Value("${test.a}")
    private String a;

    public UserService getUserService1() {
        return userService1;
    }

    public void setUserService1(UserService userService1) {
        this.userService1 = userService1;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Override
    public void test() {
        userService1.a();
        System.out.println(a);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("aaa");
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("aaa");
    }
}
