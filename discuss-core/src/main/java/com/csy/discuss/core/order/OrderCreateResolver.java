package com.csy.discuss.core.order;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderCreateResolver implements InitializingBean, ApplicationContextAware {

    private ApplicationContext applicationContext;

    private Map<String, OrderCreateTemplate> orderCreateHandlerMap = new HashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() {
        Map<String, OrderCreateTemplate> beanMap = applicationContext.getBeansOfType(OrderCreateTemplate.class);
        for (String key : beanMap.keySet()) {
            this.orderCreateHandlerMap.put(beanMap.get(key).orderType(), beanMap.get(key));
        }
    }

    public OrderCreateTemplate getHandler(String orderType) {
        return orderCreateHandlerMap.get(orderType);
    }

}
