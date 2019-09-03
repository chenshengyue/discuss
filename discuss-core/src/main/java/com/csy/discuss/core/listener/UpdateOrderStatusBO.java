package com.csy.discuss.core.listener;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateOrderStatusBO {

    private Long orderId;

    private String orderSn;

    private Integer newStatus;

    private Integer oldStatus;

}
