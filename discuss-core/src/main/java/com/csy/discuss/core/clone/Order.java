package com.csy.discuss.core.clone;

import lombok.Data;

import java.io.*;
import java.util.List;

@Data
public class Order implements Cloneable, Serializable {

    private static final long serialVersionUID = -1L;

    private Long id;

    private List<OrderItem> orderItems;

    public Object deepClone() throws IOException, ClassNotFoundException {
        // 序列化
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(this);

        // 反序列化
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);

        return ois.readObject();
    }

}
