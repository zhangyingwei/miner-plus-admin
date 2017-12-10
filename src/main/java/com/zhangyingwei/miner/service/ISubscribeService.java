package com.zhangyingwei.miner.service;

import com.zhangyingwei.miner.common.Page.PageInfo;
import com.zhangyingwei.miner.exception.MinerServerException;
import com.zhangyingwei.miner.model.Subscribe;

import java.util.List;

/**
 * @author: zhangyw
 * @date: 2017/12/9
 * @time: 下午9:57
 * @desc:
 */
public interface ISubscribeService {
    List<Subscribe> listSubscribes(String email, Integer flag) throws MinerServerException;
    List<Subscribe> listSubscribesByPage(PageInfo pageInfo, String email, Integer flag) throws MinerServerException;
    void addToBlack(Integer id) throws MinerServerException;
    void backFromBlack(Integer id) throws MinerServerException;
}
