package com.ccl.exp.mvptest.event;

/**
 * Created by ccl on 2017/11/24.
 */

public class MyEvent {
    private String msg;

    public MyEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
