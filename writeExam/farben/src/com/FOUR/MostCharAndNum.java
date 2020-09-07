package com.FOUR;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MostCharAndNum {

    public void deleteTheMost(String str){

        char[] ch = str.toCharArray();
        Map<Character,Integer> map = new TreeMap<>();
        Map maps = new HashMap();

        //遍历字符数组，统计每个字符出现的次数并存放在Map中（key：字符；value：出现次数）。
        for (int i = 0; i < ch.length; i++) {
            Integer num = map.get(ch[i]);
            map.put(ch[i], (num==null)?1:num+1);
        }

        //将字符数组中的第一个字符的个数作为哨兵进行比较
        int number = map.get(ch[0]);

        //list存放出现次数最多的字符
        ArrayList<Character> list = new ArrayList<>();

        //找出出现最多次的字符
        for (int i = 0; i < ch.length; i++) {
            if(map.get(ch[i]) > number){
                number = map.get(ch[i]);
                list.clear();
                list.add(ch[i]);
            }else if(map.get(ch[i]) == number){
                list.add(ch[i]);
            }
        }

        //删除出现最多的字符
        for (char c : list) {
            System.out.println(c);
            str = str.replace(String.valueOf(c), "");
        }

        System.out.println(str);
    }
}
