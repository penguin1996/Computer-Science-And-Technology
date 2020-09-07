package com.annotation;

import java.lang.reflect.Field;

//注解处理器
public class FruitInfoUtil {
    public static void getFruitInfo(Class<?> clazz) {
        String fruitProvider = "供应商信息：供应商编号：";
        //反射获取处理注解
        Field[] fields = clazz.getDeclaredFields();
        for(Field field:fields){
            if(field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProviders = field.getAnnotation(FruitProvider.class);
                fruitProvider = fruitProvider+
                        +fruitProviders.id()
                        +"；供应商名称："+fruitProviders.name()
                        +"；供应商地址："+fruitProviders.address();
                System.out.println(fruitProvider);
            }
        }
    }
}
