package com.csy.discuss.core.design.pipeline.context;

import com.alibaba.fastjson.JSON;
import lombok.Data;

@Data
public class BaseContext {

    private String key;

    public String toJsonString() {
        return JSON.toJSONString(this);
    }
}
