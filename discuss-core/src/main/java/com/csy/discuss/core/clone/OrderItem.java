package com.csy.discuss.core.clone;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderItem implements Cloneable, Serializable {

    private static final long serialVersionUID = -1L;

    private String name;

    public OrderItem() {

    }

    public OrderItem(String name) {
        this.name = name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
