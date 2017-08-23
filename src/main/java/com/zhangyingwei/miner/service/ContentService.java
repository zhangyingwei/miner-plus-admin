package com.zhangyingwei.miner.service;

import com.zhangyingwei.miner.common.Page.PageInfo;
import com.zhangyingwei.miner.exception.MinerServerException;
import com.zhangyingwei.miner.mapper.ContentMapper;
import com.zhangyingwei.miner.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by zhangyw on 2017/8/23.
 */
@Service
public class ContentService implements IContentService {
    @Autowired
    private ContentMapper contentMapper;
    @Override
    public List<Content> listAllContents(PageInfo pageInfo) throws MinerServerException {
        try {
            Integer count = this.contentMapper.count();
            pageInfo.setTotal(count);
            return this.contentMapper.listContentsWithPage(pageInfo.getStart(),pageInfo.limit());
        } catch (Exception e) {
            throw new MinerServerException(e);
        }
    }

    @Override
    public List<Content> listUnValidContents() throws MinerServerException {
        try {
            return this.contentMapper.listContentsByState(Content.STATE_INIT);
        } catch (Exception e) {
            throw new MinerServerException(e);
        }
    }

    @Override
    public void validContent(String id) throws MinerServerException {
        try {
            this.contentMapper.updateStateById(id, Content.STATE_NOMAL);
        } catch (Exception e) {
            throw new MinerServerException(e);
        }
    }

    @Override
    public void addContentToBlack(String id) throws MinerServerException {
        try {
            this.contentMapper.updateStateById(id, Content.STATE_NO);
        } catch (Exception e) {
            throw new MinerServerException(e);
        }
    }
}
