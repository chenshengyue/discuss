package com.csy.discuss.core.design.engine;

import com.csy.discuss.core.common.Result;
import com.csy.discuss.core.design.pipeline.context.BaseContext;

public interface EngineExecutor<T, S extends BaseContext> {

    String group();

    /**
     * 一个引擎支持多种类型的下单 实现类return "A||B"
     */
    String name();

    Result execute(T t, S s) throws Throwable;

}
