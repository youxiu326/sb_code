package com.huarui.controller;

import com.huarui.bean.SiteOptions;
import com.huarui.config.ContextStartup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/")
@Controller
public class ContextCtrl {

    @Autowired
    private SiteOptions siteOptions;


    @Autowired
    private ContextStartup contextStartup;


    @RequestMapping("/startUp")
    @ResponseBody
    public String startUp(){

        return siteOptions.getVersion()+siteOptions.getOptions().toString();

    }

    @RequestMapping("/reload")
    @ResponseBody
    public String reload(){

        contextStartup.reloadOptions(false);

        return "ok";
    }

} 