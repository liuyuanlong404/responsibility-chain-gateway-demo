package com.lakers.chain.handler.impl;

import com.lakers.chain.handler.AbstractGatewayHandler;

/**
 * Created on 2023/6/16 09:48
 *
 * @author lakers
 */
public class SessionLimitGatewayHandler extends AbstractGatewayHandler {

    @Override
    public void doFilter() {
        System.out.println("会话限流");
    }
}
