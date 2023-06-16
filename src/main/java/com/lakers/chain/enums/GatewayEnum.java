package com.lakers.chain.enums;

import com.lakers.chain.entity.GatewayEntity;
import com.lakers.chain.handler.impl.ApiLimitGatewayHandler;
import com.lakers.chain.handler.impl.BlackListLimitGatewayHandler;
import com.lakers.chain.handler.impl.SessionLimitGatewayHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created on 2023/6/15 16:23
 *
 * @author lakers
 */
@Getter
@AllArgsConstructor
public enum GatewayEnum {

    // handlerId, 拦截者名称，处理类，preHandlerId，nextHandlerId
    API_HANDLER(new GatewayEntity(1, "api接口限流", ApiLimitGatewayHandler.class, null, 2)),
    BLACKLIST_HANDLER(new GatewayEntity(2, "黑名单拦截", BlackListLimitGatewayHandler.class, 1, 3)),
    SESSION_HANDLER(new GatewayEntity(3, "用户会话拦截", SessionLimitGatewayHandler.class, 2, null)),;

    private final GatewayEntity gatewayEntity;
}
