package com.zhangyingwei.miner.mapper;

import com.zhangyingwei.miner.common.Page.PageInfo;
import com.zhangyingwei.miner.mapper.sqlprovider.SubscribeSqlPrivider;
import com.zhangyingwei.miner.model.Subscribe;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: zhangyw
 * @date: 2017/12/9
 * @time: 下午10:05
 * @desc:
 */
@Mapper
public interface SubscribeMapper {
    @Select("select * from mp_subscribe")
    List<Subscribe> listSubscribes() throws Exception;
    @SelectProvider(type = SubscribeSqlPrivider.class, method = "listSunscribesWithParams")
    List<Subscribe> listSubscribesWithParams(@Param("pageInfo") PageInfo pageInfo,@Param("email") String email, @Param("flag") Integer flag) throws Exception;
    @Select("select count(1) from mp_subscribe")
    Integer count() throws Exception;
    @Select("select * from mp_subscribe limit #{page.start},#{page.size}")
    List<Subscribe> listSubscribesByPage(@Param("page") PageInfo pageInfo) throws Exception;
    @Update("update mp_subscribe set flag=#{flag} where id=#{id}")
    void updateFlagById(@Param("id") Integer id, @Param("flag") Integer flag) throws Exception;
}
