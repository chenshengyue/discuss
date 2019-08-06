package com.csy.discuss.core.design.pipeline.rollback;

import com.csy.discuss.core.design.pipeline.InvocationChain;
import com.csy.discuss.core.design.pipeline.context.BaseContext;

/**
 * 失败回调，比如发下单失败消息
 */
public interface RollBack<T, S extends BaseContext> {

    void rollBack(InvocationChain<T, S> invocationChain);

}
