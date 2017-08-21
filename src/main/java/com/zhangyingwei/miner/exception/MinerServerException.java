package com.zhangyingwei.miner.exception;

/**
 * Created by zhangyw on 2017/8/21.
 */
public class MinerServerException extends Exception {
    public MinerServerException() {
    }

    public MinerServerException(String message) {
        super(message);
    }

    public MinerServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public MinerServerException(Throwable cause) {
        super(cause);
    }

    public MinerServerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
