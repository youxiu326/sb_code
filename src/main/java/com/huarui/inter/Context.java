package com.huarui.inter;

import com.huarui.factory.StrategyFactory;

import java.math.BigDecimal;

public class Context {

    public BigDecimal calRecharge(Integer channelId,Integer goodsId) throws Exception {
        Strategy strategy = StrategyFactory.getInstance().creator(channelId);
        return strategy.calRecharge(channelId,goodsId);
    }
} 