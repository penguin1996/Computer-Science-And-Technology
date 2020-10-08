package com.luban.init;

import com.luban.config.AppConfig;
import com.luban.service.WebInit;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * 需要咨询JAVA高级VIP课程的可以加白浅老师的QQ：2207192173
 * 需要视频资料或者咨询课程的可以加若曦老师的QQ：2408349392
 * author：鲁班学院-商鞅老师
 */
public class MyWebApplicationInitializer implements WebApplicationInitializer {


    //0配置原理
    //servlet 3.0 SPI规范
    //AppConfig
    //内嵌Tomcat
    //自己实现SPI..
    // 为什么 spring boot  能解析 非 web app 目录下的资源


    //实现0xml
    //写一个类 实现spring 的接口：WebApplicationInitializer


    //tomcat 启动的时候会调用 onStartup方法 为什么？

    //传入一个ServletContext ： web上下文对象   web.xml能做的 ServletContext都能做
    //因为servlet 3.0的一个新规范   为什么不是tomcat规范而是servlet规范
    //SPI “你”
    @Override
    public void onStartup(ServletContext servletCxt) {
        //初始化spring 容器  以注解的方式
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(AppConfig.class);
//        ac.setServletContext(servletCxt);
//        ac.refresh();
        DispatcherServlet servlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletCxt.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
//        registration.setInitParameter("contextConfigLocation","spring mvc.xml 的地址");
        registration.addMapping("*.do");
}
}