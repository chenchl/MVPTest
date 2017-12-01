package com.ccl.exp.mvptest.utils;

import android.content.Context;

/**
 * share本地类
 */
public enum SharedType {

    EM_SETTING("EM_SETTING", Context.MODE_PRIVATE),
    EM_LOGIN("EM_LOGIN", Context.MODE_PRIVATE),
    EM_NOTIFY("EM_NOTIFY", Context.MODE_PRIVATE),
    EM_GONGLI("EM_GONGLI", Context.MODE_PRIVATE),
    EM_LOGIN_INFO("EM_LOGIN_INFO", Context.MODE_PRIVATE),
    EM_DIARY_TEMP("EM_DIARY_TEMP", Context.MODE_PRIVATE),
    EM_MYDIARY_TEMP("EM_MYDIARY_TEMP", Context.MODE_PRIVATE),
    EM_READINFO("EM_READINFO", Context.MODE_PRIVATE),
    EM_READPASS("EM_READPASS", Context.MODE_PRIVATE),
    EM_STEALGOLD("EM_STEALGOLD", Context.MODE_PRIVATE),
    EM_PARENTINFO("EM_PARENTINFO", Context.MODE_PRIVATE),
    EM_MAILMSG("EM_MAILMSG", Context.MODE_PRIVATE),
    EM_TEACMSG("EM_TEACMSG", Context.MODE_PRIVATE),
    EM_CAMPAIGNMSG("EM_CAMPAIGNMSG", Context.MODE_PRIVATE),
    EM_CURRENTSTORY("EM_CURRENTSTORY", Context.MODE_PRIVATE),
    EM_WATCHVIDEO("EM_WATCHVIDEO", Context.MODE_PRIVATE),
    EM_VIDEOCATEGORY("EM_VIDEOCATEGORY", Context.MODE_PRIVATE),
    EM_APPROVE("EM_APPROVE", Context.MODE_PRIVATE),
    EM_MONEY("EM_MONEY", Context.MODE_PRIVATE);

    SharedType(String key, int mode) {
        this.key = key;
        this.mode = mode;
    }

    private String key;
    private int mode;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

}
