package com.csy.discuss.core.design.pipeline.pipe;

import com.csy.discuss.core.design.pipeline.InvocationChain;
import com.csy.discuss.core.design.pipeline.context.BaseContext;
import com.csy.discuss.core.design.pipeline.rollback.RollBack;
import com.csy.discuss.core.exception.BizException;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public abstract class AbstractPipe<T, S extends BaseContext> implements Pipe<T, S> {

    @Override
    public void invoke(InvocationChain<T, S> invocationChain) {

        T parameter = invocationChain.getParameter();
        S context = invocationChain.getContext();

        if (isFilter(parameter, context)) {
            log.info("{} : filter {} ...context = {}",
                    invocationChain.getContext().getKey(), this.getClass().getSimpleName(), context.toJsonString());

        } else {

            rollbackAdd(invocationChain);

            bizHandler(parameter, context);

            if (invocationChain.isBroken()) {
                log.error("{} : invoke {} error...context = {}",
                        invocationChain.getContext().getKey(), this.getClass().getSimpleName(), context.toJsonString(), invocationChain.getThrowable());
            }else {
                log.info("{} : invoke {} end...context = {}",
                        invocationChain.getContext().getKey(), this.getClass().getSimpleName(), context.toJsonString());
            }

        }

        invocationChain.invokeNext();

    }

    /**
     * 在管道公用的情况下，根据入参和上下文判断是否过滤这个管道
     * @param t
     * @param s
     * @return
     */
    protected abstract boolean isFilter(T t, S s);

    /**
     * 执行业务
     */
    protected abstract void bizHandler(T t, S s);


    private void rollbackAdd(InvocationChain<T, S> invocationChain) {
        List<RollBack<T, S>> rollBackList = invocationChain.getRollBackList();
        if (this instanceof RollBack && rollBackList != null) {
            rollBackList.add((RollBack) this);
        }
    }

}
