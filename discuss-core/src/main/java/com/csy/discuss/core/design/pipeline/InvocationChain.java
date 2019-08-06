package com.csy.discuss.core.design.pipeline;

import com.csy.discuss.core.design.pipeline.context.BaseContext;
import com.csy.discuss.core.design.pipeline.pipe.Pipe;
import com.csy.discuss.core.design.pipeline.rollback.RollBack;

import java.util.List;

/**
 * 调用链封装类
 */
public interface InvocationChain<T, S extends BaseContext> {

    void invoke();

    void invokeNext();

    S getContext();

    Throwable getThrowable();

    boolean isFinished();

    boolean isBroken();

    T getParameter();

    void breakPipeline(Pipe<T, S> pipe, Throwable t);

    List<RollBack<T, S>> getRollBackList();

}
