package com.zero.springaop;

import com.zero.springaop.staticproxy.IA;
import com.zero.springaop.staticproxy.ProxyIA;
import com.zero.springaop.staticproxy.RealIA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
//强制使用Cglib动态代理
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringaopApplication {

    public static void main(String[] args) { SpringApplication.run(SpringaopApplication.class, args); }
}
