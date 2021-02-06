package com.zero.springaop.aop;

import com.zero.springaop.security.AuthService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

    @Autowired
    AuthService authService;

    //匹配方法标注有AdminOnly的注解的方法
    @Pointcut("@annotation(com.zero.springaop.annotation.AdminOnly)")
    public void adminOnly() {

    }

    //匹配方法标注有NeedSecureed注解的类中方法，要求annotation的RetentionPolicy级别为ClASS
    @Pointcut("@within(com.zero.springaop.annotation.NeedSecured)")
    public void secured(){

    }

    //匹配标注有Repository注解的类中方法，要求annotation的RetentionPolicy级别为RUNTIME
    @Pointcut("@target(org.springframework.stereotype.Repository)")
    public void target(){

    }

    //匹配传入的参数类标注有Repositroy注解的方法
    @Pointcut("@args(org.springframework.stereotype.Repository)")
    public void args(){

    }

    //匹配ProductService类中的所有方法
    @Pointcut("within(com.zero.springaop.service.ProductService)")
    public void mathType(){

    };

    //匹配com.zero包及其子包中所有类的方法
    @Pointcut("within(com.zero..*)")
    public void mathPackage(){

    }

    //匹配AOP对象的目标对象为指定类型的方法，及UserServiceImpl的aop代理对象的方法
    @Pointcut("this(com.zero.springaop.service.impl.UserServiceImpl)")
    public void thisInstance(){

    }

    //匹配实现UserService接口的目标对象(而不是AOP代理后的对象)的方法，这里即UserServiceImpl的方法
    @Pointcut("target(com.zero.springaop.service.UserService)")
    public void targetInstance(){

    }

    //匹配所有以Service结尾的bean中的方法
    @Pointcut("bean(*Service)")
    public void beanInstance(){

    }

    //匹配任何以get开头且只有一个类型为Long参数的方法
    @Pointcut("execution(* *..get*(Long))")
    public void argsInstance(){

    }

    //匹配任何另有一个Long参数的方法
    @Pointcut("args(Long)")
    public void argsInstanceL(){

    }

    //匹配任何以get开头的而且第一个参数为Long型的方法
    @Pointcut("execution(* *..get*(Long,..))")
    public void argsInstances() {

    }

    //匹配第一个参数为Long型的方法
    @Pointcut("args(Long,..)")
    public void argsInstanced(){

    }

    @Before("adminOnly()")
    public void checkAccess(){
        authService.checkAccess();
    }
}
