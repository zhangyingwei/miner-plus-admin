package com.zhangyingwei.miner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhangyw on 2017/8/21.
 */
@Controller
@RequestMapping("/sites")
public class SiteController {

    @GetMapping
    public String sites(){
        return "sites/SiteInfo";
    }

    @GetMapping("/news")
    public String news(){
        return "sites/NewSites";
    }

    @GetMapping("/contents")
    public String content(){
        return "sites/SiteContents";
    }
}
