package com.lakers.chain.entity;

import com.lakers.chain.handler.AbstractGatewayHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 2023/6/15 16:24
 *
 * @author lakers
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GatewayEntity {

    private Integer handlerId;

    private String name;

    private Class<? extends AbstractGatewayHandler> clazz;

    private Integer preHandlerId;

    private Integer nextHandlerId;
}
