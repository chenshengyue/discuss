package com.csy.discuss.core.design.pipeline.pipe;

import com.csy.discuss.core.design.pipeline.InvocationChain;
import com.csy.discuss.core.design.pipeline.context.BaseContext;

/**
 * 处理管道
 *
 * Created by yaojiafeng on 2019/3/7 9:11 PM.
 */
public interface Pipe<T, S extends BaseContext> {

    void invoke(InvocationChain<T, S> invocationChain);

}
