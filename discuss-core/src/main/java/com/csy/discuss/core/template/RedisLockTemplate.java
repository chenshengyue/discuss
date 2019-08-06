package com.csy.discuss.core.template;

public interface RedisLockTemplate {

    void doBiz(String key, Long expireTime, Object object, CallBack callBack);

}
