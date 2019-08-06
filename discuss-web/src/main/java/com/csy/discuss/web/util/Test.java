package com.csy.discuss.web.util;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

public class Test {

    @Getter
    @Setter
    public static class User {

        private Integer id;

        private String name;

        public User() {

        }

        public User(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int hashCode() {
            return id == null ? null : id.toString().length();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof User) {
                User user = (User) obj;
                return this.getId().equals(user.getId());
            }
            return false;
        }

    }

    public static void main(String[] args) {
        Set<User> sets = new LinkedHashSet<>();
        User user1 = new User();
        user1.setId(1);
        user1.setName("1");
        User user2 = new User();
        user2.setId(2);
        user2.setName("2");
        sets.add(user1);
        sets.add(user2);

        System.out.println(JSON.toJSONString(sets));
        User user3 = new User();
        user3.setId(1);
        user3.setName("1");
        boolean a = sets.contains(user3);
        System.out.println(a);
    }
}
