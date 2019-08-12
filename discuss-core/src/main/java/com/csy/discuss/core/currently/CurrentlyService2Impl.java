package com.csy.discuss.core.currently;

import org.springframework.beans.factory.annotation.Autowired;

public class CurrentlyService2Impl implements CurrentlyService2 {

    @Autowired
    private CurrentlyService1 currentlyService1;

}
