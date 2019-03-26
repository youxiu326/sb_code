package com.huarui.pay;

import com.huarui.inter.Strategy;
import com.huarui.util.InitNewService;

import java.math.BigDecimal;

@Pay(2)
public class ICBCPay extends InitNewService implements Strategy {
    
    @Override
    public BigDecimal calRecharge(Integer channelId, Integer goodsId) {
        //通过渠道id查询优惠折扣

        //通过商品id查询商品价格

        //返回商品最终价格
        return new BigDecimal(100);
    }
}