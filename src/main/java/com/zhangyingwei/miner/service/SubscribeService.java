package com.zhangyingwei.miner.service;

import com.zhangyingwei.miner.common.Page.PageInfo;
import com.zhangyingwei.miner.exception.MinerServerException;
import com.zhangyingwei.miner.mapper.SubscribeMapper;
import com.zhangyingwei.miner.model.Subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: zhangyw
 * @date: 2017/12/9
 * @time: 下午9:57
 * @desc:
 */
@Service
public class SubscribeService implements ISubscribeService {
    @Autowired
    private SubscribeMapper subscribeMapper;
    @Override
    public List<Subscribe> listSubscribes(String email, Integer flag) throws MinerServerException {
        try {
            List<Subscribe> subscribes = this.subscribeMapper.listSubscribesWithParams(null,email,flag);
            return subscribes;
        } catch (Exception e) {
            throw new MinerServerException(e);
        }
    }

    @Override
    public List<Subscribe> listSubscribesByPage(PageInfo pageInfo, String email, Integer flag) throws MinerServerException {
        try {
            Integer count = this.subscribeMapper.count();
            pageInfo.setTotal(count);
            List<Subscribe> subscribes = this.subscribeMapper.listSubscribesWithParams(pageInfo, email, flag);
            return subscribes;
        } catch (Exception e) {
            throw new MinerServerException(e);
        }
    }

    @Override
    public void addToBlack(Integer id) throws MinerServerException {
        try {
            this.subscribeMapper.updateFlagById(id,Subscribe.FLAG_BLACK);
        } catch (Exception e) {
            throw new MinerServerException(e);
        }
    }

    @Override
    public void backFromBlack(Integer id) throws MinerServerException {
        try {
            this.subscribeMapper.updateFlagById(id, Subscribe.FLAG_VALID);
        } catch (Exception e) {
            throw new MinerServerException(e);
        }
    }
}
