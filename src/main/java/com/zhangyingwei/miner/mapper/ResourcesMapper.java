package com.zhangyingwei.miner.mapper;

import com.zhangyingwei.miner.model.Resources;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * Created by zhangyw on 2017/8/22.
 */
@Mapper
public interface ResourcesMapper {
    @Select("select * from mp_resources order by id desc limit #{start},#{limit}")
    List<Resources> listResourcesLimit(@Param("start") Integer start,@Param("limit") Integer limit) throws Exception;

    @Select("select count(*) from mp_resources")
    Integer count() throws Exception;

    @Select("select * from mp_resources where flag=#{state} order by id desc")
    List<Resources> listResourcesByState(@Param("state") Integer state) throws Exception;

    @Update("update mp_resources set flag=#{state}, updatedate=#{updatadate} where id=#{id}")
    void updateResourcesState(@Param("id") String id,@Param("state") Integer state,@Param("updatadate") String updatedate) throws Exception;

    @UpdateProvider(type = ResourcesUpdateProvider.class, method = "updateResourcesById")
    void updateResourcesById(Resources resources) throws Exception;

    class ResourcesUpdateProvider {
        public String updateResourcesById(Resources resources) {
            return new SQL(){{
                UPDATE("mp_resources");
                if(resources.getGroup() != null){
                    SET("group=#{group}");
                }

            }}.toString();
        }
    }
}
