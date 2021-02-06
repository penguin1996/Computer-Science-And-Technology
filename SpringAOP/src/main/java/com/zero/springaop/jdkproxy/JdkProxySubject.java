package com.zero.springaop.jdkproxy;

import com.zero.springaop.staticproxy.RealIA;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkProxySubject implements InvocationHandler {

    private RealIA realIA;

    public JdkProxySubject(RealIA realIA) {
        this.realIA = realIA;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //通过invoke方法执行动态代理的逻辑
        System.out.println("before代理");

        Object result = null;
        try{
            //通过反射,来动态反射方法
            result = method.invoke(realIA,args);

        }catch (Exception e){

        }finally {
            System.out.println("after代理");
        }
        return result;
    }
}
