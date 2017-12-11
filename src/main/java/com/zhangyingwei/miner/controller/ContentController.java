package com.zhangyingwei.miner.controller;

import com.zhangyingwei.miner.common.Page.PageInfo;
import com.zhangyingwei.miner.common.ajax.Ajax;
import com.zhangyingwei.miner.exception.MinerServerException;
import com.zhangyingwei.miner.model.Content;
import com.zhangyingwei.miner.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangyw on 2017/8/23.
 */
@Controller
@RequestMapping("/sites/contents")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @GetMapping("/{page}")
    public String content(@PathVariable("page") Integer page, Map model) throws MinerServerException {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setCurrentPage(page);
        List<Content> all = this.contentService.listAllContents(pageInfo);
        List<Content> unvalid = this.contentService.listUnValidContents();
        model.put("allcontent", all);
        model.put("unvalid", unvalid);
        model.put("page", pageInfo);
        return "sites/SiteContents";
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Map validContent(@PathVariable("id") String id) throws MinerServerException {
        this.contentService.validContent(id);
        return Ajax.RESULT.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Map addToBlack(@PathVariable("id") String id) throws MinerServerException {
        this.contentService.addContentToBlack(id);
        return Ajax.RESULT.success();
    }

}
