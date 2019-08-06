package com.csy.discuss.core.service.impl;

import com.csy.discuss.core.annotation.TestAspectTag;
import com.csy.discuss.core.service.AopTestService;
import org.springframework.stereotype.Service;

@Service
public class AopTestServiceImpl implements AopTestService {

    @TestAspectTag
    @Override
    public void a() {
        System.out.println(111);
    }
}
