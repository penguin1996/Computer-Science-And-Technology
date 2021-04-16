package com.test.hashMap;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;


public class HashMapTest {

    public static void main( String[] args ) {

        Object o = new Object();
        Thread thread = new Thread();
        Runnable runnable;

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

        ThreadPoolExecutor threadPoolExecutor;

        Map<String, Integer> hashMap = new HashMap<>();

        Throwable throwable;
        Error error;

        Graphics graphics;

        hashMap.put("k1", 1);
        hashMap.put("k2", 2);
        hashMap.put("k3", 3);
        hashMap.put("k4", 4);

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + "：" + entry.getValue());
        }
    }
}
