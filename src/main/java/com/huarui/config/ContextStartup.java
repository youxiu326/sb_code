package com.huarui.config;

import com.huarui.bean.SiteOptions;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ContextStartup implements ApplicationRunner, ServletContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContextStartup.class);

    private ServletContext servletContext;

    @Autowired
    private SiteOptions siteOptions;


    //实现ServletContextAware 可获得上下文 servletContext
    @Override
    public void setServletContext(ServletContext servletContext) {
        LOGGER.info("获得上下文");
        this.servletContext = servletContext;
    }

    //实现ApplicationRunner   可在springboot应用启动后进行初始化操作
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        LOGGER.info("sprinboot 启动啦");

        reloadOptions(true);
    }

    //刷新
    public void reloadOptions(boolean startup){
        LOGGER.info("servletContext reload");

        Map<String, String> map = new HashMap<>();

        map.put("key1","val1");
        map.put("key2","val2");
        if (!startup){
            map.put("key3","val3");
        }

        siteOptions.setOptions(map);
        //将对象 全局共享
        servletContext.setAttribute("site", siteOptions);
    }

}