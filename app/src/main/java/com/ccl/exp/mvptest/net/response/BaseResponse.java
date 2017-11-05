package com.ccl.exp.mvptest.net.response;

import java.io.Serializable;

/**
 * Created by ccl on 2016/3/23.
 */
public class BaseResponse<T> implements Serializable {
    public int code;
    public String message;
    public T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isResponseOK() {
        if (code != 200)
            return false;
        else
            return true;
    }
}
