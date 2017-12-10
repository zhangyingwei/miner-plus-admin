package com.zhangyingwei.miner.common.ajax;

import com.zhangyingwei.miner.common.Page.PageInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by zhangyw on 2017/8/22.
 */
public class AjaxResult {
    private static final String KEY_STATE = "state";
    private static final String KEY_MSG = "message";
    private static final String KEY_DATA = "data";

    private static final Integer STATE_SUCCESS = 200;
    private static final Integer STATE_ERROR = 400;

    private static final String MSG_SUCCESS = "success";
    private static final String MSG_ERROR = "error";

    private static final String KEY_PAGE = "page";

    private Map resultMap = new HashMap();

    public Map success(Object data){
        return this.success(MSG_SUCCESS, data);
    }

    public Map success(String message){
        return this.result(STATE_SUCCESS, message);
    }

    public Map success() {
        return this.success(MSG_SUCCESS);
    }

    public Map success(String msgSuccess, Object data) {
        return this.result(STATE_SUCCESS,msgSuccess,data);
    }

    public Map error(String errorMessage){
        return this.result(STATE_ERROR, errorMessage);
    }

    public AjaxResult page(PageInfo pageInfo) {
        this.resultMap.put(KEY_PAGE, pageInfo);
        return this;
    }

    private Map result(Integer stateError, String errorMessage) {
        this.resultMap.put(KEY_STATE, stateError);
        this.resultMap.put(KEY_MSG, errorMessage);
        return this.resultMap;
    }

    private Map result(Integer stateSuccess, String msgSuccess, Object data) {
        this.resultMap.put(KEY_STATE, stateSuccess);
        this.resultMap.put(KEY_MSG, msgSuccess);
        this.resultMap.put(KEY_DATA, data);
        return this.resultMap;
    }
}
