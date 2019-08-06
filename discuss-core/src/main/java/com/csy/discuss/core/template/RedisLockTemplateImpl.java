package com.csy.discuss.core.template;

import org.springframework.stereotype.Service;

@Service
public class RedisLockTemplateImpl implements RedisLockTemplate {

    @Override
    public void doBiz(String key, Long expireTime, Object object, CallBack callBack) {
        try {
            callBack.callBack(object);
        } catch (Exception e) {

        } finally {

        }
    }

}
