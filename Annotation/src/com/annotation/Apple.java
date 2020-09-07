package com.annotation;

//使用注解
public class Apple {

    @FruitProvider(id = 1, name = "陕西红富士集团",address = "陕西省西安市延安路")
    private String appProvider;

    public String getAppProvider() {
        return appProvider;
    }

   /* public Apple setAppProvider(String appProvider) {
        this.appProvider = appProvider;
        return this;
    }*/

    public void setAppProvider(String appProvider) {
        this.appProvider = appProvider;
    }
}
