package com.csy.discuss.web;

import com.csy.discuss.core.autowire.UniqueService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireApplication {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/AutowireApplicationContext.xml");
        UniqueService uniqueService = (UniqueService) context.getBean("uniqueServiceImpl");
        uniqueService.a();

    }

}
