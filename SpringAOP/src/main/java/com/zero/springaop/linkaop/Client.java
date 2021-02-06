package com.zero.springaop.linkaop;

public class Client {
    static class HandlerA extends Handler{

        @Override
        protected void handleProcess() {
            System.out.println("handled by a");
        }
    }

    static class HandlerB extends Handler{

        @Override
        protected void handleProcess() {
            System.out.println("handled by b");
        }
    }

    static class HandlerC extends Handler{

        @Override
        protected void handleProcess() {
            System.out.println("handled by c");
        }
    }

    public static void main(String[] args) {
        Handler handlerA = new HandlerA();
        Handler handlerB = new HandlerB();
        Handler handlerC = new HandlerC();

        handlerA.setSuccessor(handlerB);
        handlerB.setSuccessor(handlerC);

        handlerA.execute();
    }
}
