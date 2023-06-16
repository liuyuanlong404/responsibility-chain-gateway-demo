package com.lakers.chain.dao.impl;

import com.lakers.chain.dao.GatewayDao;
import com.lakers.chain.entity.GatewayEntity;
import com.lakers.chain.enums.GatewayEnum;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created on 2023/6/15 16:29
 *
 * @author lakers
 */
public class GatewayDaoImpl implements GatewayDao {

    /**
     * 初始化，将枚举中配置的handler初始化到map中，方便获取
     */
    private static final Map<Integer, GatewayEntity> GATEWAY_ENTITY_MAP = new HashMap<>();

    static {
        GatewayEnum[] values = GatewayEnum.values();
        for (GatewayEnum value : values) {
            GatewayEntity gatewayEntity = value.getGatewayEntity();
            GATEWAY_ENTITY_MAP.put(gatewayEntity.getHandlerId(), gatewayEntity);
        }
    }

    @Override
    public GatewayEntity getGatewayEntity(Integer handlerId) {
        return GATEWAY_ENTITY_MAP.get(handlerId);
    }

    @Override
    public GatewayEntity getFirstGatewayEntity() {
        AtomicReference<GatewayEntity> firstGatewayEntity = new AtomicReference<>();
        GATEWAY_ENTITY_MAP.forEach((k, v) -> {
            if (v.getPreHandlerId() == null) {
                firstGatewayEntity.set(v);
            }
        });
        return firstGatewayEntity.get();
    }
}
