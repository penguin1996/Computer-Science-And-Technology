package com.luban.cotroller;

import com.luban.annocation.UserParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import sun.security.provider.MD5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

/**
 * 需要咨询JAVA高级VIP课程的可以加白浅老师的QQ：2207192173
 * 需要视频资料或者咨询课程的可以加若曦老师的QQ：2408349392
 * author：鲁班学院-商鞅老师
 */
@Controller
public class TestController  {



    @RequestMapping("/test.do")
    @ResponseBody                                                   //user 对象  Map
    public Object test(String name, HttpServletRequest request, HttpServletResponse response ,@UserParam Map map){
        System.out.println("调用了");
        request.getParameter("name");
        Map hashMap = new HashMap();
//        {}
        hashMap.put("key","value");
        return  hashMap;
    }

    @RequestMapping("/model.do")
//    @ResponseBody
    public String model(HttpServletRequest request,HttpServletResponse response){
        // /page/index.html
        return "index";
    }



    @RequestMapping("/xml.do")
    public void xml(HttpServletResponse response){
        CreateXml.build01(response);
    }

}
