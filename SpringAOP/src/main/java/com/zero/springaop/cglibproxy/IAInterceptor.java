package com.zero.springaop.cglibproxy;


import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class IAInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("before in cglib");
            Object result = null;
            try{
                result = methodProxy.invokeSuper(o,objects);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }finally {
                System.out.println("after in cglib");
            }
            return result;
    }
}
