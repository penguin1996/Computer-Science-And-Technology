package com.zero.springaop.staticproxy;

public class ProxyIA implements IA{

    //代理对象需要委托真正对象去完成一些逻辑
    private RealIA realIA;

    //强制
    public ProxyIA(RealIA realIA) {
        this.realIA = realIA;
    }

    //代理对象不会实现真是的逻辑
    @Override
    public void getName() {

        //类似于AOP的before,after,around
        //代理对象完成其他逻辑
        System.out.println("before代理逻辑");

        //代理对象委托真正的对象来完成客户端逻辑
        try {
            realIA.getName();
        } catch (Exception e) {
            System.out.println("ex:" + e.getMessage());
            throw e;
        } finally {
            System.out.println("after代理逻辑");
        }
    }
}
