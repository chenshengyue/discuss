package com.csy.discuss.core.design.engine;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class EngineResolver implements InitializingBean, ApplicationContextAware {

    private ApplicationContext applicationContext;

    private Map<String, EngineExecutor> EngineExecutorMap = new HashMap<>();

    @Override
    public void afterPropertiesSet() {
        Map<String, EngineExecutor> beanMap = applicationContext.getBeansOfType(EngineExecutor.class);
        for (String key : beanMap.keySet()) {
            EngineExecutor executor = beanMap.get(key);
            String[] beanNames = executor.name().split("\\|\\|");
            for (String beanName : beanNames) {
                this.EngineExecutorMap.put(executor.group() + beanName.trim(), beanMap.get(key));
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public EngineExecutor getExecutor(String name) {
        return EngineExecutorMap.get(name);
    }
}
