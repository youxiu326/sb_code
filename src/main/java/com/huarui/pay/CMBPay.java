package com.huarui.pay;

import com.huarui.inter.Strategy;
import com.huarui.util.CommonUtil;
import com.huarui.util.InitNewService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@Pay(1)
public class CMBPay extends InitNewService implements Strategy {

    @Autowired
    private CommonUtil commonUtil;

    @Override
    public BigDecimal calRecharge(Integer channelId, Integer goodsId) {
        //通过渠道id查询优惠折扣

        //通过商品id查询商品价格

        System.out.println(commonUtil.injectStr());

        //返回商品最终价格
        return new BigDecimal(100);
    }
}