package com.zhangyingwei.miner.mapper.sqlprovider;

import com.zhangyingwei.miner.common.Page.PageInfo;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author: zhangyw
 * @date: 2017/12/9
 * @time: 下午11:12
 * @desc:
 */
public class SubscribeSqlPrivider  {
    private Logger logger = LoggerFactory.getLogger(SubscribeSqlPrivider.class);
    public String listSunscribesWithParams(Map<String,Object> para) {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM("mp_subscribe");
                WHERE("1=1");
                if (null != para.get("email") && (para.get("email")+"").length() > 0) {
                    AND();
                    WHERE("email = #{email}");
                }
                if (null != para.get("flag")) {
                    AND();
                    WHERE("flag = #{flag}");
                }
            }
        }.toString();
        PageInfo pageInfo = (PageInfo) para.get("pageInfo");
        if (pageInfo != null && pageInfo.valid()) {
            sql += " limit #{pageInfo.start},#{pageInfo.size}";
        }
//        logger.info("sql " + sql);
//        logger.info("param " + para);
        return sql;
    }
}
