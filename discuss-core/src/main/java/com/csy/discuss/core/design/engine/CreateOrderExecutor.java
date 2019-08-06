package com.csy.discuss.core.design.engine;

import com.csy.discuss.core.annotation.ServerCatch;
import com.csy.discuss.core.common.Result;
import com.csy.discuss.core.design.pipeline.InvocationChain;
import com.csy.discuss.core.design.pipeline.Pipeline;
import com.csy.discuss.core.design.pipeline.context.BaseContext;
import com.csy.discuss.core.design.pipeline.pipe.impl.AddressPipe;
import com.csy.discuss.core.design.pipeline.pipe.impl.LogisticPipe;
import com.csy.discuss.core.design.pipeline.pipe.impl.StorePipe;
import com.csy.discuss.core.design.pipeline.rollback.RollBack;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public abstract class CreateOrderExecutor<T, S extends BaseContext> implements EngineExecutor<T, S>, InitializingBean {

    @Autowired
    protected Pipeline pipeline;

    @Autowired
    protected AddressPipe addressPipe;

    @Autowired
    protected LogisticPipe logisticPipe;

    @Autowired
    protected StorePipe storePipe;

    public String group() {
        return "createOrder_";
    }

    @Transactional
    @ServerCatch
    @Override
    public Result execute(T t, S s) throws Throwable {

        validParameter(t);

        setKey(t, s);

        InvocationChain<T, S> invocationChain = pipeline.newInvocation(t, s);

        try {

            invocationChain.invoke();

        }catch (Exception e) {

            doRollback(invocationChain);

            //抛出异常用于本地事物回滚和异常捕获器捕捉
            throw invocationChain.getThrowable();
        }

        return Result.success(true);
    }

    protected abstract void validParameter(T t);

    protected abstract void setKey(T t, S s);

    protected void doRollback(InvocationChain<T, S> invocationChain) {
        List<RollBack<T, S>> rollBackList = invocationChain.getRollBackList();
        if (CollectionUtils.isNotEmpty(rollBackList)) {
            for (RollBack<T, S> rollBack : rollBackList) {
                rollBack.rollBack(invocationChain);
            }
        }
    }
}
