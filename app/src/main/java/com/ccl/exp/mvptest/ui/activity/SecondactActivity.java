package com.ccl.exp.mvptest.ui.activity;

import com.ccl.exp.mvptest.R;
import com.ccl.exp.mvptest.event.MyEvent;

import org.greenrobot.eventbus.EventBus;

public class SecondactActivity extends BaseMvpActivity {


    @Override
    public void initBefore() {
        needEventBus = false;
    }

    @Override
    public int initXmlId() {
        return R.layout.activity_secondact;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initdata() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        EventBus.getDefault().post(new MyEvent("post!"));
    }

    @Override
    public String setTag() {
        return "second";
    }

    @Override
    public void onError(String msg) {

    }
}
