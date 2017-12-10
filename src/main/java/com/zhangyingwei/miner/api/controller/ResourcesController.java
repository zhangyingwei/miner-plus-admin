package com.zhangyingwei.miner.api.controller;

import com.zhangyingwei.miner.common.Page.PageInfo;
import com.zhangyingwei.miner.common.ajax.Ajax;
import com.zhangyingwei.miner.exception.MinerServerException;
import com.zhangyingwei.miner.model.Resources;
import com.zhangyingwei.miner.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: zhangyw
 * @date: 2017/12/10
 * @time: 下午7:26
 * @desc:
 */
@Controller
@RequestMapping("/resources")
@CrossOrigin({
        "http://localhost:2017"
})
public class ResourcesController {

    @Autowired
    private ResourcesService resourcesService;

    @GetMapping
    @ResponseBody
    public Map listResourcesWithPage(
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("currentPage") Integer currentPage,
            @RequestParam(value = "restype",required = false) String restype
    ) throws MinerServerException {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setSize(pageSize);
        pageInfo.setCurrentPage(currentPage);
        List<Resources> resources = new ArrayList<Resources>();
        if ("new".equals(restype)) {
            resources = this.resourcesService.listNewResourcesAllWithPage(pageInfo);
        }else{
            resources = this.resourcesService.listResourcesAllWithPage(pageInfo);
        }
        return Ajax.RESULT.page(pageInfo).success(resources);
    }

    @PutMapping("/blacks/{id}")
    @ResponseBody
    public Map addResourcesToBlack(@PathVariable("id") Integer id) throws MinerServerException{
        this.resourcesService.addToBlack(id+"");
        return Ajax.RESULT.success();
    }

    @GetMapping("/types")
    @ResponseBody
    public Map listTypes() throws MinerServerException {
        List<String> types = this.resourcesService.listTypes();
        return Ajax.RESULT.success(types);
    }

    @PutMapping("/valid/{id}")
    @ResponseBody
    public Map validResources(@PathVariable("id") Integer id,@RequestBody Map<String,String> params) throws MinerServerException {
        Resources resources = new Resources();
        resources.setId(id);
        resources.setRtype(params.get("rtype"));
        resources.setRgroup(params.get("rgroup"));
        resources.setFlag(Resources.FLAG_NOMAL);
        this.resourcesService.updateResourcesWithId(resources);
        return Ajax.RESULT.success();
    }
}
