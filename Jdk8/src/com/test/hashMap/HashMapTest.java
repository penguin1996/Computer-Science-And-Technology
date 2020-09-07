package com.test.hashMap;

import java.util.HashMap;
import java.util.Map;


public class HashMapTest {

    public static void main( String[] args ) {


        Map<String, Integer> hashMap = new HashMap<>();

        hashMap.put("k1", 1);
        hashMap.put("k2", 2);
        hashMap.put("k3", 3);
        hashMap.put("k4", 4);

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + "：" + entry.getValue());
        }
    }
}
