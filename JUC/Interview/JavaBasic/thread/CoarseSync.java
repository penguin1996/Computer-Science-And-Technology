package com.interview.javabasic.thread;

public class CoarseSync {
    public static String copyString100Times(String target){
        int i = 0;
        StringBuffer sb = new StringBuffer();
		
		//对于同一个StringBuffer对象加锁，锁粗化使得100次循环需要加一次锁，以提高性能
        while (i<100){
            sb.append(target);
        }
        return sb.toString();
    }
}
