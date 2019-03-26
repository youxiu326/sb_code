package com.huarui.factory;

import com.huarui.inter.Strategy;
import com.huarui.pay.Pay;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Set;

public class StrategyFactory {


    private static StrategyFactory factory = new StrategyFactory();

    public static StrategyFactory getInstance(){
        return factory;
    }

    public static HashMap<Integer,String> sourceMap = new HashMap<>();

    static {

        //反射工具包，指明扫描路径
        Reflections reflections = new Reflections("com.huarui.pay");
        //获取带我们pay注解的类
        Set<Class<?>> classSet =  reflections.getTypesAnnotatedWith(Pay.class);
        //根据注解的值，将全类名放到map中
        for (Class clazz : classSet){
            Pay pay = (Pay) clazz.getAnnotation(Pay.class);
            sourceMap.put(pay.value(),clazz.getCanonicalName());
        }

    }

    public Strategy creator(int type) throws Exception {
        String className = sourceMap.get(type);
        Class  clazz= Class.forName(className);
        return (Strategy) clazz.newInstance();
    }

} 