package com.zhangyingwei.miner.model;

import java.util.Date;

/**
 * @author: zhangyw
 * @date: 2017/12/9
 * @time: 下午10:01
 * @desc:
 */
public class Subscribe {
    private Integer id;
    private String email;
    private String topics;
    private Integer flag;
    private String subdate;
    private String dissubdate;

    public static final Integer FLAG_INIT = 0;
    public static final Integer FLAG_NOTICED = 1;
    public static final Integer FLAG_VALID = 2;
    public static final Integer FLAG_BLACK = 3;
    public static final Integer FLAG_UNSUBSCRIBE = 9;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getSubdate() {
        return subdate;
    }

    public void setSubdate(String subdate) {
        this.subdate = subdate;
    }

    public String getDissubdate() {
        return dissubdate;
    }

    public void setDissubdate(String dissubdate) {
        this.dissubdate = dissubdate;
    }

    @Override
    public String toString() {
        return "Subscribe{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", topics='" + topics + '\'' +
                ", flag=" + flag +
                ", subdate=" + subdate +
                ", dissubdate=" + dissubdate +
                '}';
    }
}
