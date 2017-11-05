package com.ccl.exp.mvptest.ui.activity;

/**
 * create by ccl 2016.3.23
 */
public interface IBaseActivity {

    void initBefore();

    int initXmlId();

    void initView();

    void initdata();

    void resume();

    String setTag();
}
