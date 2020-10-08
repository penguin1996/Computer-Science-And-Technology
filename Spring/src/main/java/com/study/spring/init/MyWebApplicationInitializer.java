package com.study.spring.init;

import com.study.spring.config.AppConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

//实现Java config的第一步就是实现WebApplicationInitializer接口
public class MyWebApplicationInitializer implements WebApplicationInitializer {

    /*
    * web容器{Tomcat等web容器}会在启动的时候去调用onStrartup(ServletContext servletCxt)，web上下文对象
    * ServletContext，Servlet的上下文，即web容器的上下文，保存web容器中的所有内容
    * web组件: filter,servlet,listener 可以在web.xml中配置
    * 新版servlet也可以用@WebFilter，@WebServlet，@WebListener进行配置
    * 此外，我们可以利用ServletContext去实现
    *  */
    @Override
    public void onStartup(ServletContext servletCxt) {

        //ClassPathXmlApplicationContext,Spring程序的入口，一个Spring容器的上下文对象
        //利用java注解的方式去初始化Spring上下文环境
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();//初始化Spring
        ac.register(AppConfig.class);//配置Spring
        //至此Spring的初始化工作已经完成
        ac.refresh();

        //SpringMVC初始化完成
        // Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(ac);
        //web组件的注册
        ServletRegistration.Dynamic registration = servletCxt.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("*.do");
    }

    /*为什么onStartup方法能够生效，servlet3.0版本之后，提出了一个新规范 SPI
    * Spring项目中如果某些类或者某些方法在启动时需要被web容器调用的时候，首先会在
    * 项目的根目录的META-INF/services目录下建立一个javax.ServletContainerInitializer文件*/

}
