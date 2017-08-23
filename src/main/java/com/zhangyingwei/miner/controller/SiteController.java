package com.zhangyingwei.miner.controller;

import com.zhangyingwei.miner.common.Page.PageInfo;
import com.zhangyingwei.miner.common.ajax.Ajax;
import com.zhangyingwei.miner.exception.MinerServerException;
import com.zhangyingwei.miner.model.Resources;
import com.zhangyingwei.miner.service.ResourcesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangyw on 2017/8/21.
 */
@Controller
@RequestMapping("/sites")
public class SiteController {

    private Logger logger = LoggerFactory.getLogger(SiteController.class);

    @Autowired
    private ResourcesService resourcesService;

    @GetMapping("/pages/{pageIndex}")
    public String sitesWithPage(@PathVariable("pageIndex") Integer pageIndex,Map model) throws MinerServerException {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setCurrentPage(pageIndex);
        List<Resources> resources = this.resourcesService.listResourcesAllWithPage(pageInfo);
        model.put("sites", resources);
        model.put("page", pageInfo);
        return "sites/SiteInfo";
    }

    @PutMapping
    @ResponseBody
    public Map sitesManage(Resources resources) throws MinerServerException {
        logger.info(resources.toString());
        return Ajax.RUSELT.success();
    }

    @DeleteMapping("/{id}")
    public Map deleteSite(@PathVariable("id") String id) throws MinerServerException {
        this.resourcesService.deleteResourcesById(id);
        return Ajax.RUSELT.success();
    }

    @GetMapping("/news")
    public String news(Map model) throws MinerServerException {
        List<Resources> resources = this.resourcesService.listResourcesStateInit();
        model.put("sites", resources);
        return "sites/NewSites";
    }

    @PutMapping("/news/{id}")
    @ResponseBody
    public Map updateNews(@PathVariable("id") String id) throws MinerServerException {
        this.resourcesService.valid(id);
        return Ajax.RUSELT.success();
    }

    @DeleteMapping("/news/{id}")
    @ResponseBody
    public Map blackNews(@PathVariable("id") String id) throws MinerServerException {
        this.resourcesService.addToBlack(id);
        return Ajax.RUSELT.success();
    }
}
