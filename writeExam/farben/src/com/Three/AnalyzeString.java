package com.Three;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class AnalyzeString {

    public void charAndNum(String s) {

        int lowerCharNum = 0, superCharNum = 0, num = 0;
        for (int i = 0; i < s.length(); i++) {

            if (48 <= s.charAt(i) && s.charAt(i) <= 57) {
                num++;
            } else if (57 <= s.charAt(i) && s.charAt(i) <= 90) {
                superCharNum++;
            } else {
                lowerCharNum++;
            }
        }
        System.out.println("字符串中大写字符个数：" + superCharNum + " 小写字符个数：" + lowerCharNum + " 数字个数：" + num);
    }

    public void charAndNum2(String s) {

        int lowerCharNum = 0, superCharNum = 0, num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (48 <= s.charAt(i) && s.charAt(i) <= 57) {
                num++;
                int j = i + 1;
                if (48 <= s.charAt(j) && s.charAt(j) <= 57) {
                    num--;
                }
            } else if (57 <= s.charAt(i) && s.charAt(i) <= 90) {
                superCharNum++;
            } else {
                lowerCharNum++;
            }
        }
        System.out.println("字符串中大写字符个数：" + superCharNum + " 小写字符个数：" + lowerCharNum + " 数字个数：" + num);
    }

    public void ignoreCase(String s) {
        int charNum = 0, num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (48 <= s.charAt(i) && s.charAt(i) <= 57) {
                num++;
                int j = i + 1;
                if (48 <= s.charAt(j) && s.charAt(j) <= 57) {
                    num--;
                }
            } else {
                charNum++;
            }
        }
        System.out.println("字符字符个数：" + charNum + " 数字个数：" + num);
    }

    //不考虑连续数字
    public void numOfCharAndNum(String s) {
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer nums = map.get(s.charAt(i));
            map.put(s.charAt(i), (nums == null) ? 1 : nums + 1);
        }

        //将字符数组中的第一个字符的个数作为哨兵进行比较
        int number = map.get(s.charAt(0));

        //list存放出现次数最多的字符
        ArrayList<Character> listChar = new ArrayList<>();
        ArrayList<Character> listInt = new ArrayList<>();

        //找出出现最多次的字符
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) > number) {
                number = map.get(s.charAt(i));
                if (48 <= s.charAt(i) && s.charAt(i) <= 57) {
                    listInt.clear();
                    listInt.add(s.charAt(i));
                } else {
                    listChar.clear();
                    listChar.add(s.charAt(i));
                }
            } else if (map.get(s.charAt(i)) == number) {
                if (48 <= s.charAt(i) && s.charAt(i) <= 57) {
                    listInt.add(s.charAt(i));
                } else {
                    listChar.add(s.charAt(i));
                }
            }
        }
        System.out.print("最多的字符是：");
        for (char c : listChar) {
            System.out.println(c + " ");
        }
        System.out.print("最多的数字是：");
        for (char c : listInt) {
            System.out.println(c + " ");
        }
    }

    /*//考虑连续数字
    public void numOfCharAndNum2(String s) {
        Map<String, Integer> map = new TreeMap<>();
        int j;

        for (int i = 0; i < s.length(); i++) {
            if (48 <= s.charAt(i) && s.charAt(i) <= 57) {
                j = i + 1;
                if (48 <= s.charAt(j) && s.charAt(j) <= 57) {
                    j++;
                }
                i = j;
            }
            Integer nums = map.get(s.substring(i, i + 1));
            map.put(s.substring(i, i + 1), (nums == null) ? 1 : nums + 1);
        }

        //将字符数组中的第一个字符的个数作为哨兵进行比较
        int number = map.get(s.substring(0, 1));

        //list存放出现次数最多的字符
        ArrayList<Character> listChar = new ArrayList<>();
        ArrayList<String> listInt = new ArrayList<>();

        //找出出现最多次的字符
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.substring(i + i + 1)) > number) {
                number = map.get(s.substring(i,i+1));
                if (48 <= s.charAt(i) && s.charAt(i) <= 57) {
                    listInt.clear();
                    listInt.add(s.substring(i,i+1));
                } else {
                    listChar.clear();
                    listChar.add(s.charAt(i));
                }
            } else if (map.get(s.charAt(i)) == number) {
                if (48 <= s.charAt(i) && s.charAt(i) <= 57) {
                    listInt.add(s.charAt(i));
                } else {
                    listChar.add(s.charAt(i));
                }
            }
        }
        System.out.print("最多的字符是：");
        for (char c : listChar) {
            System.out.println(c + " ");
        }
        System.out.print("最多的数字是：");
        for (String c : listInt) {
            System.out.println(c + " ");
        }
    }*/
}
