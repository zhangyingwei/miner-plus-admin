package com.zhangyingwei.miner.service;

import com.zhangyingwei.miner.common.Page.PageInfo;
import com.zhangyingwei.miner.exception.MinerServerException;
import com.zhangyingwei.miner.model.Content;

import java.util.List;

/**
 * Created by zhangyw on 2017/8/23.
 */
public interface IContentService {
    List<Content> listAllContents(PageInfo pageInfo) throws MinerServerException;
    List<Content> listUnValidContents() throws MinerServerException;
    void validContent(String id) throws MinerServerException;
    void addContentToBlack(String id) throws MinerServerException;
}
