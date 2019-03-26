package com.huarui.pay;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) //注解定义到类上
@Retention(RetentionPolicy.RUNTIME) //生命周期
public @interface Pay {

    int value();

} 