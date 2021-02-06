package com.zero.springaop.linkaop;

import java.util.List;

public class Chain {

    private int index = 0;

    private List<ChainHandler> handlerList;

    public Chain(List<ChainHandler> handlerList) {
        this.handlerList = handlerList;
    }

    public void proceed() {
        if(index >= handlerList.size()) {
            return;
        }
        handlerList.get(index++).execute(this);
    }
}
