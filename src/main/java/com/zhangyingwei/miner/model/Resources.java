package com.zhangyingwei.miner.model;

/**
 * Created by zhangyw on 2017/8/22.
 */
public class Resources {
    public static final Integer FLAG_INIT = 0;
    public static final Integer FLAG_NOMAL = 1;
    public static final Integer FLAG_INVALID = 2;
    private Integer id;
    private String resources;
    private String group;
    private String type;
    private String createdate;
    private String updatedate;
    private Integer flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Resources{" +
                "id=" + id +
                ", resources='" + resources + '\'' +
                ", group='" + group + '\'' +
                ", type='" + type + '\'' +
                ", createdate='" + createdate + '\'' +
                ", updatedate='" + updatedate + '\'' +
                ", flag=" + flag +
                '}';
    }
}