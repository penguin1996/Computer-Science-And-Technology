package com.zero.springaop.linkaop;

//解决AOP的链式调用
public abstract class Handler {

    private Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    //对外暴露
    public void execute() {

        //处理自己的handleProcess
        handleProcess();
        if(successor != null ){
            successor.execute();
        }
    }

    protected  abstract void handleProcess();
}
