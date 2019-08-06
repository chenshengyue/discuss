package com.csy.discuss.core.design.pipeline;

import com.csy.discuss.core.design.pipeline.context.BaseContext;
import com.csy.discuss.core.design.pipeline.pipe.Pipe;

import java.util.List;

/**
 * 管道
 */
public interface Pipeline<T, S extends BaseContext> {

    void setPipeList(List<Pipe> pipeList);

    InvocationChain<T, S> newInvocation(T t, S s);

}
