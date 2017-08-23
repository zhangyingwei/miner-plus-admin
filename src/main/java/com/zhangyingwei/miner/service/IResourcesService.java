package com.zhangyingwei.miner.service;

import com.zhangyingwei.miner.common.Page.PageInfo;
import com.zhangyingwei.miner.exception.MinerServerException;
import com.zhangyingwei.miner.model.Resources;

import java.util.List;

/**
 * Created by zhangyw on 2017/8/22.
 */
public interface IResourcesService {
    List<Resources> listResourcesStateInit() throws MinerServerException;

    List<Resources> listResourcesAllWithPage(PageInfo pageInfo) throws MinerServerException;

    void valid(String id) throws MinerServerException;

    void addToBlack(String id) throws MinerServerException;

    void updateResourcesWithId(Resources resources) throws MinerServerException;

    void deleteResourcesById(String id) throws MinerServerException;
}
