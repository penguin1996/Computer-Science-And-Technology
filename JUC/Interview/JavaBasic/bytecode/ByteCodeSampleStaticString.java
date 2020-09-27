package com.interview.javabasic.bytecode;

public class ByteCodeSampleStaticString {
	
	static int k;
	static String m;
    public static void main(String[] args) {
        int i;
		int j;
		m = "abc";
		j = 5;
		i = 1;
		k = 3;
		m = m+m;
		k *= 3;
		++j;
        i++;
		System.out.println(k);
		System.out.println(j);
        System.out.println(i);
    }
}
