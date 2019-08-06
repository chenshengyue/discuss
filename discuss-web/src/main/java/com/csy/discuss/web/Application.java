package com.csy.discuss.web;

import com.csy.discuss.core.bean.TestService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Application {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        TestService testService = (TestService) context.getBean("testService");
        testService.test();

//        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring/applicationContext.xml"));
//        AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
//        autowiredAnnotationBeanPostProcessor.setBeanFactory(bf);
//        ((XmlBeanFactory) bf).addBeanPostProcessor(autowiredAnnotationBeanPostProcessor);
//
//        TestService testService = (TestService) bf.getBean("testService");
//        testService.test();
    }

}
