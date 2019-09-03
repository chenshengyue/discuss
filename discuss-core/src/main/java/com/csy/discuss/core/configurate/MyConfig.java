package com.csy.discuss.core.configurate;

import com.csy.discuss.core.common.Result;
import com.csy.discuss.core.entity.Order;
import com.csy.discuss.core.service.OrderService;
import com.csy.discuss.core.service.impl.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.csy.discuss.core.configurate")
public class MyConfig {

    @Bean
    public ConfigTestService configTestService() {
        return new ConfigTestService();
    }

    @Bean(initMethod = "abc")
    public ConfigService configService() {
        return new ConfigService();
    }


}
