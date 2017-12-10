package com.zhangyingwei.miner.mapper;

import com.zhangyingwei.miner.model.Resources;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangyw on 2017/8/22.
 */
@Mapper
public interface ResourcesMapper {
    @Select("select res.id as id,res.resources as resources,res.rgroup as rgroup,res.rtype as rtype,res.createdate as createdate,res.updatedate as updatedate,res.flag as flag from mp_resources res order by id desc limit #{start},#{limit}")
    List<Resources> listResourcesLimit(@Param("start") Integer start,@Param("limit") Integer limit) throws Exception;

    @Select("select count(*) from mp_resources")
    Integer count() throws Exception;

    @Select("select count(*) from mp_resources where flag=#{flag}")
    Integer countWithFlag(@Param("flag") Integer flag) throws Exception;

    @Select("select * from mp_resources where flag=#{state} order by id desc")
    List<Resources> listResourcesByState(@Param("state") Integer state) throws Exception;

    @Update("update mp_resources set flag=#{state}, updatedate=#{updatadate} where id=#{id}")
    void updateResourcesState(@Param("id") String id,@Param("state") Integer state,@Param("updatadate") String updatedate) throws Exception;

    @UpdateProvider(type = ResourcesUpdateProvider.class, method = "updateResourcesById")
    void updateResourcesById(@Param("res") Resources resources) throws Exception;

    @Select("select * from mp_resources where flag=#{flag} limit #{start},#{limit}")
    List<Resources> listResourcesLimitWithFlag(@Param("start") Integer start, @Param("limit") Integer limit, @Param("flag") Integer flag);

    @Select("select rtype from mp_resources group by rtype")
    List<String> listTypes() throws Exception;

    class ResourcesUpdateProvider {
        public String updateResourcesById(Map<String,Resources> res) {
            Resources resources = res.get("res");
            String sql = new SQL() {{
                UPDATE("mp_resources");
                if (StringUtils.isNotBlank(resources.getRgroup())) {
                    SET("mp_resources.rgroup=#{res.rgroup}");
                }
                if (StringUtils.isNotBlank(resources.getRtype())) {
                    SET("rtype=#{res.rtype}");
                }
                if (resources.getFlag() != null) {
                    SET("flag=#{res.flag}");
                }
                WHERE("id=#{res.id}");
            }}.toString();
//            System.out.println(sql);
            return sql;
        }
    }
}
