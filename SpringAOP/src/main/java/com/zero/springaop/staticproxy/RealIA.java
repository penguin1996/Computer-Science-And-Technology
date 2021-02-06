package com.zero.springaop.staticproxy;

public class RealIA implements IA{

    @Override
    public void getName() {
        System.out.println("真正对象实现请求!");
    }
}
