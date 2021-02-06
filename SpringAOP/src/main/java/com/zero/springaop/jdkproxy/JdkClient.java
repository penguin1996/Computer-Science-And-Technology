package com.zero.springaop.jdkproxy;

import com.zero.springaop.staticproxy.IA;
import com.zero.springaop.staticproxy.RealIA;

import java.lang.reflect.Proxy;

public class JdkClient {

    public static void main(String[] args) {
        IA ia = (IA) Proxy.newProxyInstance(JdkClient.class.getClassLoader(),new Class[]{IA.class},new JdkProxySubject(new RealIA()));
        ia.getName();
    }
}
