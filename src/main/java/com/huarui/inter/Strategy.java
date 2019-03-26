package com.huarui.inter;

import java.math.BigDecimal;

public interface Strategy {

    /**
     * 计算支付金额 通过渠道id和商品id 进行价格计算
     * @param channelId
     * @param goodsId
     * @return
     */
    BigDecimal calRecharge(Integer channelId,Integer goodsId);

} 