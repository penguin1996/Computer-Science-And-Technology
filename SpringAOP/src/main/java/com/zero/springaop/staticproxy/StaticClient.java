package com.zero.springaop.staticproxy;

public class StaticClient {

    public static void main(String[] args) {
        IA ias =  new ProxyIA(new RealIA());
        ias.getName();
    }
}
