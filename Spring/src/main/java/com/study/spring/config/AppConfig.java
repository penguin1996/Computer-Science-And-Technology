package com.study.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration //声明一个配置类
@ComponentScan
public class AppConfig extends WebMvcConfigurationSupport {

    //WebMvcConfigurationSupport是用来配置SpringMVC，而非是初始化SpringMVC，并不是一定要继承，因为SpringMVC有默认的配置,并不一定需要自定义配置
}
