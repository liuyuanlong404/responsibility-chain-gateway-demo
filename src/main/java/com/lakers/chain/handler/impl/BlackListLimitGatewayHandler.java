package com.lakers.chain.handler.impl;

import com.lakers.chain.handler.AbstractGatewayHandler;

/**
 * Created on 2023/6/16 09:47
 *
 * @author lakers
 */
public class BackListLimitGatewayHandler extends AbstractGatewayHandler {
    @Override
    public void doFilter() {
        System.out.println("黑名单限流");
    }
}
