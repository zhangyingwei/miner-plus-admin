package com.zhangyingwei.miner.api.controller;

import com.zhangyingwei.miner.common.Page.PageInfo;
import com.zhangyingwei.miner.common.ajax.Ajax;
import com.zhangyingwei.miner.exception.MinerServerException;
import com.zhangyingwei.miner.model.Subscribe;
import com.zhangyingwei.miner.service.ISubscribeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * @author: zhangyw
 * @date: 2017/12/9
 * @time: 下午9:53
 * @desc:
 */
@Controller
@RequestMapping("/subscribes")
@CrossOrigin(origins = {
        "http://localhost:2017"
},maxAge = 3600)
public class SubscribeController {
    private Logger logger = LoggerFactory.getLogger(SubscribeController.class);
    @Autowired
    private ISubscribeService subscribeService;

    @GetMapping
    @ResponseBody
    public Map listSubscribes(
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            @RequestParam(value = "currentPage", required = false, defaultValue = "-1") Integer currentPage,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "flag", required = false) Integer flag
    ) throws MinerServerException {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setSize(pageSize);
        pageInfo.setCurrentPage(currentPage);
        logger.info(pageInfo.toString());
        logger.info(email,flag);
        if (pageInfo.valid()) {
            List<Subscribe> subscribes = this.subscribeService.listSubscribesByPage(pageInfo,email,flag);
            return Ajax.RESULT.page(pageInfo).success(subscribes);
        } else {
            List<Subscribe> subscribes = this.subscribeService.listSubscribes(email,flag);
            return Ajax.RESULT.success(subscribes);
        }
    }

    @PutMapping("/blacks/{id}")
    @ResponseBody
    public Map addToBlack(@PathVariable("id") Integer id) throws MinerServerException {
        this.subscribeService.addToBlack(id);
        return Ajax.RESULT.success();
    }

    @RequestMapping(value = "/valids/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public Map backFromBlack(@PathVariable("id") Integer id) throws MinerServerException {
        this.subscribeService.backFromBlack(id);
        return Ajax.RESULT.success();
    }

}
