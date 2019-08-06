package com.csy.discuss.core.template;

import org.springframework.beans.factory.annotation.Autowired;

public class Test {

    @Autowired
    private RedisLockTemplate redisLockTemplate;

    public void a() {
        redisLockTemplate.doBiz("1", 1L, new RedisDto(), new CallBack<RedisDto>() {
            @Override
            public void callBack(RedisDto o) {

            }
        });
    }
}
