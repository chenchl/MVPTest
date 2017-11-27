package com.ccl.exp.mvptest.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ccl.exp.mvptest.presenter.BasePresenter;
import com.ccl.exp.mvptest.view.IBaseView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ccl on 2017/11/3.
 */

public abstract class BaseMvpActivity extends BaseActivity implements IBaseView {

    protected List<BasePresenter> mPresenters = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    protected void addPresenter(BasePresenter presenter) {
        mPresenters.add(presenter);
    }

    @Override
    protected void onDestroy() {
        for (BasePresenter p : mPresenters) {
            p.cancelHttp();
            p.detach();
        }
        mPresenters.clear();
        mPresenters = null;
        super.onDestroy();
    }

    @Override
    public Context getContext() {
        return this;
    }
}
