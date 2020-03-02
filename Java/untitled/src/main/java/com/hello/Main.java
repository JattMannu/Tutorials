package com.hello;

import jdk.internal.util.xml.impl.Pair;

import java.util.*;
import java.util.function.BiConsumer;

public class Main {

    TreeMap<String, Integer> users;

    void init() {
        users = new TreeMap<String, Integer>();
        users.put("Weng Wei", 1);
        users.put("Christ", 7);
        users.put("Mark", 2);

        Integer total = 0;
        for (Integer value : users.values()) {
            total += value;
        }

        users.e
        System.out.println(getName(users,total));



    }

    public String getName(Map<String, Integer> map , Integer total) {
        Random random = new Random();
        final Integer randomInt = random.nextInt(total);
        map.forEach((key, value) -> {


        });
    }
}


