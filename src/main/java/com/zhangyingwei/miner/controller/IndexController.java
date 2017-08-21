package com.zhangyingwei.miner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhangyw on 2017/8/21.
 */
@Controller
@RequestMapping
public class IndexController {

    @GetMapping
    public String index(){
        return "index";
    }
}
