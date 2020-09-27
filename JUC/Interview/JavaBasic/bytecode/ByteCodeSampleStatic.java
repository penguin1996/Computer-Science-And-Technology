package com.interview.javabasic.bytecode;

public class ByteCodeSampleStatic {
	
	static int k;
    public static void main(String[] args) {
        int i;
		int j;
		j = 5;
		i = 1;
		k = 3;
		k *= 3;
		++j;
        i++;
		System.out.println(k);
		System.out.println(j);
        System.out.println(i);
    }
}
