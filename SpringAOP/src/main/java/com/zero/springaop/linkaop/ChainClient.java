package com.zero.springaop.linkaop;

import java.util.Arrays;
import java.util.List;

//Spring就是通过chain的方式实现的
public class ChainClient {

    static class ChainHandlerA extends ChainHandler{

        @Override
        protected void handleProcess() {

        }
    }  static class ChainHandlerB extends ChainHandler{

        @Override
        protected void handleProcess() {

        }
    }  static class ChainHandlerC extends ChainHandler{

        @Override
        protected void handleProcess() {

        }
    }

    public static void main(String[] args) {
        List<ChainHandler> chainHandlerList = Arrays.asList(
                new ChainHandlerA(),
                new ChainHandlerB(),
                new ChainHandlerC()
        );

        Chain chain = new Chain(chainHandlerList);
        chain.proceed();
    }
}
