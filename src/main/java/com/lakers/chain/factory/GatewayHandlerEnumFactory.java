package com.lakers.chain.factory;

import com.lakers.chain.dao.GatewayDao;
import com.lakers.chain.dao.impl.GatewayDaoImpl;
import com.lakers.chain.entity.GatewayEntity;
import com.lakers.chain.handler.AbstractGatewayHandler;
import lombok.SneakyThrows;

/**
 * Created on 2023/6/15 16:35
 *
 * @author lakers
 */
public class GatewayHandlerEnumFactory {

    private static final GatewayDao GATEWAY_DAO = new GatewayDaoImpl();

    public static AbstractGatewayHandler getFirstGatewayHandler() {
        GatewayEntity firstGatewayEntity = GATEWAY_DAO.getFirstGatewayEntity();
        // 获取第一个handler
        AbstractGatewayHandler firstGatewayHandler = newGatewayHandler(firstGatewayEntity);

        GatewayEntity tempGatewayEntity = firstGatewayEntity;
        Integer nextHandlerId;
        AbstractGatewayHandler tempAbstracGatewayHandler = firstGatewayHandler;
        // 迭代遍历所有handler，以及将它们链接起来
        while ((nextHandlerId = tempGatewayEntity.getNextHandlerId()) != null) {
            // 获取下一个GatewayEntity
            GatewayEntity gatewayEntity = GATEWAY_DAO.getGatewayEntity(nextHandlerId);
            // 实例化下一个handler
            AbstractGatewayHandler gatewayHandler = newGatewayHandler(gatewayEntity);
            // 将链链接起来
            tempAbstracGatewayHandler.setNext(gatewayHandler);
            // 重新赋值
            tempAbstracGatewayHandler = gatewayHandler;
            // 重新赋值
            tempGatewayEntity = gatewayEntity;
        }
        // 返回第一个handler
        return firstGatewayHandler;
    }

    /**
     * 反射实体化具体的处理者
     */
    @SneakyThrows
    private static AbstractGatewayHandler newGatewayHandler(GatewayEntity gatewayEntity) {
        // 获取处理者的class
        Class<? extends AbstractGatewayHandler> clazz = gatewayEntity.getClazz();
        return clazz.getDeclaredConstructor().newInstance();

    }
}
