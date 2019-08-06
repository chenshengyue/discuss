package com.csy.discuss.core.sign;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SignResolver implements InitializingBean, ApplicationContextAware {

    private ApplicationContext applicationContext;

    private Map<String, Sign> signHandlerMap = new HashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() {
        Map<String, Sign> beanMap = applicationContext.getBeansOfType(Sign.class);
        for (String key : beanMap.keySet()) {
            this.signHandlerMap.put(beanMap.get(key).companyType(), beanMap.get(key));
        }
    }

    public Sign getHandler(String companyType) {
        return signHandlerMap.get(companyType);
    }

}
