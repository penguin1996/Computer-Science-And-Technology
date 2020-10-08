//package com.luban;
//
////import org.apache.catalina.Context;
////import org.apache.catalina.LifecycleException;
////import org.apache.catalina.LifecycleListener;
////import org.apache.catalina.startup.Tomcat;
//import org.apache.catalina.Context;
//import org.apache.catalina.LifecycleListener;
//import org.apache.catalina.startup.Tomcat;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//public class App {
//
//    public static void main(String[] args) throws Exception {
//        Tomcat tomcat = new Tomcat();
//        tomcat.setPort(80);
//        //
//        Context context = tomcat.addContext("/", System.getProperty("java.io.tmpdir"));
//        //只会去初始化一个 context的资源目录 并不会加载 web的生命周期
//        // webapps
//        // .war   文件夹
//        //        tomcat.addWebapp("/","C:\\Program Files\\pro\\public-luban-project\\spring-mvc\\src\\main\\webapp");
//        context.addLifecycleListener((LifecycleListener) Class.forName(tomcat.getHost().getConfigClass()).newInstance());
//        tomcat.start();
//
//        tomcat.getServer().await();
//
//        //传一个xml文件进去
////        ClassPathXmlApplicationContext
////                classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
//
//
//    }
//}
