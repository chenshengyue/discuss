package com.csy.discuss.core.design.pipeline.context;

import lombok.Getter;
import lombok.Setter;

/**
 * 上下文储藏类，方法间传递参数
 */
@Getter
@Setter
public class CreateOrderContext extends BaseContext {

    private String addressContext;

    private String logisticContext;

}
