package com.huarui.factory;

import com.huarui.inter.Strategy;
import com.huarui.pay.Pay;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Set;

/**
 * 【工厂类】
 * 通过指定扫码路径读取带有自定义注解Pay的类
 * <br>并将全类名保存至map中，格式为["pay的value":"类的全类名"]
 * <br> 定义了creator方法，传入支付类型 返回 指定支付对象
 */
public class StrategyFactory {


    private static StrategyFactory factory = new StrategyFactory();

    /**
     * 单例
     * @return
     */
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
        //取得全类名
        String className = sourceMap.get(type);
        //取得类对象
        Class  clazz= Class.forName(className);
        //反射创建对象
        return (Strategy) clazz.newInstance();
    }

} 