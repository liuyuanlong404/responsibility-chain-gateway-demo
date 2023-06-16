package com.lakers.chain;

import com.lakers.chain.factory.GatewayHandlerEnumFactory;
import com.lakers.chain.handler.AbstractGatewayHandler;

/**
 * Created on 2023/6/16 10:03
 *
 * @author lakers
 */
public class GatewayClient {

    public static void main(String[] args) {
        AbstractGatewayHandler firstGatewayHandler = GatewayHandlerEnumFactory.getFirstGatewayHandler();
        firstGatewayHandler.startFilter();
    }
}
