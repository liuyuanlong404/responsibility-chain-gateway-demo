package com.lakers.chain.handler;

/**
 * Created on 2023/6/15 16:37
 *
 * @author lakers
 */
public abstract class AbstractGatewayHandler {

    public AbstractGatewayHandler nextGatewayHandler;

    protected abstract void doFilter();

    public void setNext(AbstractGatewayHandler gatewayHandler) {
        this.nextGatewayHandler = gatewayHandler;
    }

    public void startFilter() {
        doFilter();
        while (nextGatewayHandler != null) {
            nextGatewayHandler.doFilter();
            nextGatewayHandler = nextGatewayHandler.nextGatewayHandler;
        }
    }
}
