package com.lakers.chain.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2023/6/15 16:37
 *
 * @author lakers
 */
public  class GatewayHandler {

    private GatewayHandler nextGatewayHandler;



    public void setNext(GatewayHandler gatewayHandler) {
        this.nextGatewayHandler = gatewayHandler;
    }

    public static void main(String[] args) {
        String s = "abcda";
        int[][] queries = {{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}};
        List<Boolean> booleans = new GatewayHandler().canMakePaliQueries(s, queries);
        System.out.println(booleans);
    }sou
}
