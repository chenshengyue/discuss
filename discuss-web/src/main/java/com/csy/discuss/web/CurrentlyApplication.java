package com.csy.discuss.web;

import com.csy.discuss.core.currently.CommonBean;
import com.csy.discuss.core.currently.CurrentlyService1;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class CurrentlyApplication {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/CurrentlyApplicationContext.xml");
        CommonBean commonBean = (CommonBean) context.getBean("commonBeanImpl");

    }

}
