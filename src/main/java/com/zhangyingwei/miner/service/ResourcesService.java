package com.zhangyingwei.miner.service;

import com.zhangyingwei.miner.common.Page.PageInfo;
import com.zhangyingwei.miner.exception.MinerServerException;
import com.zhangyingwei.miner.mapper.ResourcesMapper;
import com.zhangyingwei.miner.model.Resources;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangyw on 2017/8/22.
 */
@Service
public class ResourcesService implements IResourcesService {

    @Autowired
    private ResourcesMapper resourcesMapper;

    @Override
    public List<Resources> listResourcesStateInit() throws MinerServerException {
        try {
            return this.resourcesMapper.listResourcesByState(Resources.FLAG_INIT);
        } catch (Exception e) {
            throw new MinerServerException(e);
        }
    }

    @Override
    public List<Resources> listResourcesAllWithPage(PageInfo pageInfo) throws MinerServerException {
        try {
            Integer count = this.resourcesMapper.count();
            pageInfo.setTotal(count);
            return this.resourcesMapper.listResourcesLimit(pageInfo.getStart(), pageInfo.limit());
        } catch (Exception e) {
            throw new MinerServerException(e);
        }
    }

    @Override
    public void valid(String id) throws MinerServerException{
        try {
            this.resourcesMapper.updateResourcesState(id,Resources.FLAG_NOMAL, DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
        } catch (Exception e) {
            throw new MinerServerException(e);
        }
    }

    @Override
    public void addToBlack(String id) throws MinerServerException{
        try {
            this.resourcesMapper.updateResourcesState(id,Resources.FLAG_INVALID,DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
        } catch (Exception e) {
            throw new MinerServerException(e);
        }
    }

    @Override
    public void updateResourcesWithId(Resources resources) throws MinerServerException{
        try {
            if(resources.getId() == null){
                throw new MinerServerException("resources.id is empty");
            }
            this.resourcesMapper.updateResourcesById(resources);
        } catch (Exception e) {
            throw new MinerServerException(e);
        }
    }

    @Override
    public void deleteResourcesById(String id) throws MinerServerException {
        Resources resources = new Resources();
        resources.setId(Integer.parseInt(id));
        resources.setFlag(Resources.FLAG_DEL);
        try {
            this.resourcesMapper.updateResourcesById(resources);
        } catch (Exception e) {
            throw new MinerServerException(e);
        }
    }

}
