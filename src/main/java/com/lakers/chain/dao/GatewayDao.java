package com.lakers.chain.dao;

import com.lakers.chain.entity.GatewayEntity;

/**
 * @author lakers
 */
public interface GatewayDao {
  
    /**  
     * 根据 handlerId 获取配置项
     */  
    GatewayEntity getGatewayEntity(Integer handlerId);
  
    /**  
     * 获取第一个处理者  
     */
    GatewayEntity getFirstGatewayEntity();  
}