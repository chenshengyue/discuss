package com.csy.discuss.web;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComponentScanApplication {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/ComponentScanApplicationContext.xml");

    }

}
