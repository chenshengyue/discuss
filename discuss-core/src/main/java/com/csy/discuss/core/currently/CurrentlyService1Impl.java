package com.csy.discuss.core.currently;

import org.springframework.beans.factory.annotation.Autowired;

public class CurrentlyService1Impl implements CurrentlyService1 {

//    @Autowired
//    private CommonBean commonBean;

    @Autowired
    private CurrentlyService2 currentlyService2;
}
