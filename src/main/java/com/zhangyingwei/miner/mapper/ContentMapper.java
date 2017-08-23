package com.zhangyingwei.miner.mapper;

import com.zhangyingwei.miner.model.Content;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by zhangyw on 2017/8/23.
 */
@Mapper
public interface ContentMapper {

    @Select("select * from mp_content where state=#{state} order by id desc")
    List<Content> listContentsByState(@Param("state") Integer state) throws Exception;

    @Select("select * from mp_content order by id desc limit #{start},#{limit}")
    List<Content> listContentsWithPage(@Param("start") Integer start, @Param("limit") Integer limit) throws Exception;

    @Select("select count(*) from mp_content")
    Integer count() throws Exception;

    @Update("update mp_content set state=#{state} where id=#{id}")
    void updateStateById(@Param("id") String id,@Param("state") Integer state) throws Exception;


}
