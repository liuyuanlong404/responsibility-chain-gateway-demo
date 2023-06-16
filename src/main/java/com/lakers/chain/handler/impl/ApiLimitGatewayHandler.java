package com.lakers.chain.handler.impl;

import com.lakers.chain.handler.AbstractGatewayHandler;

/**
 * Created on 2023/6/16 09:46
 *
 * @author lakers
 */
public class ApiLimitGatewayHandler extends AbstractGatewayHandler {

    @Override
    public void doFilter() {
        System.out.println("api限流");
    }

}
