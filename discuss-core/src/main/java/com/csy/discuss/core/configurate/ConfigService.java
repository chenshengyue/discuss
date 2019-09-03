package com.csy.discuss.core.configurate;

import org.springframework.beans.factory.annotation.Autowired;

public class ConfigService {

    @Autowired
    private ConfigTestService configTestService;

    public void abc() {
        configTestService.say();
    }

}
