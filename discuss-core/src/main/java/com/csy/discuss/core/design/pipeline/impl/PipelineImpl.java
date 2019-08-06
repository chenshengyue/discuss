package com.csy.discuss.core.design.pipeline.impl;

import com.alibaba.fastjson.JSON;
import com.csy.discuss.core.design.pipeline.InvocationChain;
import com.csy.discuss.core.design.pipeline.context.BaseContext;
import com.csy.discuss.core.design.pipeline.pipe.Pipe;
import com.csy.discuss.core.design.pipeline.Pipeline;
import com.csy.discuss.core.design.pipeline.rollback.RollBack;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 管道实现载体
 *
 */
@Slf4j
@Component
public class PipelineImpl<T, S extends BaseContext> implements Pipeline<T, S> {

    private List<Pipe> pipeList = new ArrayList<>();

    public List<Pipe> getPipeList() {
        return pipeList;
    }

    @Override
    public void setPipeList(List<Pipe> pipeList) {

        this.pipeList = pipeList;
    }

    @Override
    public InvocationChain<T, S> newInvocation(T t, S s) {

        return new InvocationImpl(t, s);
    }

    /**
     * 内部类
     * @param <T>
     */
    private final class InvocationImpl<T, S extends BaseContext> implements InvocationChain<T, S> {

        private T parameter;

        private boolean broken;

        private Pipe breakPipe = null;

        private int executedIndex = -1;

        private S context;

        private Throwable t;

        private List<RollBack<T, S>> rollBackList = Lists.newArrayList();

        public InvocationImpl(T parameter, S context) {
            this.parameter = parameter;
            this.context = context;
        }

        @Override
        public boolean isBroken() {
            return broken;
        }

        @Override
        public void invoke() {
            if (isBroken()) {
                return;
            }
            executedIndex = -1;
            log.info("{} : begin invoke...request = {}",
                    this.getContext().getKey(), JSON.toJSONString(this.getParameter()));
            invokeNext();
        }

        @Override
        public boolean isFinished() {
            return !broken && executedIndex >= pipeList.size();
        }

        @Override
        public T getParameter() {
            return parameter;
        }

        @Override
        public void breakPipeline(Pipe<T, S> pipe, Throwable t) {
            this.broken = true;
            this.breakPipe = pipe;
            this.t = t;
        }

        @Override
        public List<RollBack<T, S>> getRollBackList() {
            return rollBackList;
        }

        @Override
        public void invokeNext() {
            if (isBroken()) {
                return;
            }

            executedIndex++;
            if (executedIndex < pipeList.size()) {
                Pipe pipe = pipeList.get(executedIndex);

                pipe.invoke(this);
            }

        }

        @Override
        public S getContext() {
            return context;
        }

        @Override
        public Throwable getThrowable() {
            return t;
        }

    }
}
