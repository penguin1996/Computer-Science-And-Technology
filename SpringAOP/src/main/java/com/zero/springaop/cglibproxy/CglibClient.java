package com.zero.springaop.cglibproxy;

import com.zero.springaop.staticproxy.IA;
import com.zero.springaop.staticproxy.RealIA;
import org.springframework.cglib.proxy.Enhancer;

public class CglibClient {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealIA.class);
        enhancer.setCallback(new IAInterceptor());
        IA ia = (IA) enhancer.create();
        ia.getName();
    }
}
