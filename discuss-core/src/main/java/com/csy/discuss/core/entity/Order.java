package com.csy.discuss.core.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Order implements Serializable {

    private Long id;

    private String orderSn;

    private Long userId;

    private Long totalAmount;

    private Long actualAmount;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    private String orderType;

    private static final long serialVersionUID = 1L;

}