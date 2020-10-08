package com.luban.cotroller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 需要咨询JAVA高级VIP课程的可以加白浅老师的QQ：2207192173
 * 需要视频资料或者咨询课程的可以加若曦老师的QQ：2408349392
 * author：鲁班学院-商鞅老师
 */
@Component("/user.do")  //<bean  beanName="/getUser"></bean>
// Spring MVC 2种类型的Controller  注解  BeanName    3种方式实现
//BeanName 2大类型的controller 3种方式实现Controller
public class BeanNameController implements Controller{



    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("beanName");
        return null;
    }
}
