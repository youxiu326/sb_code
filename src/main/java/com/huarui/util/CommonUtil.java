package com.huarui.util;

import org.springframework.stereotype.Component;

@Component
public class CommonUtil {

    public String injectStr(){
        return "当注入的spring管理的对象时，报错";
    }

} 