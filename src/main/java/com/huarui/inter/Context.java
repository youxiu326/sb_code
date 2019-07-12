package com.huarui.inter;

import com.huarui.factory.StrategyFactory;

import java.math.BigDecimal;

public class Context {

    /**
     *
     * @param channelId 支付类型id
     * @param goodsId   商品id
     * @return
     * @throws Exception
     */
    public BigDecimal calRecharge(Integer channelId,Integer goodsId) throws Exception {
        Strategy strategy = StrategyFactory.getInstance().creator(channelId);
        return strategy.calRecharge(channelId,goodsId);
    }
} 