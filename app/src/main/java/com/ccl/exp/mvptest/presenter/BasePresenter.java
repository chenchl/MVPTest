package com.ccl.exp.mvptest.presenter;

import com.ccl.exp.mvptest.view.IBaseView;

/**
 * Created by ccl on 2017/11/3.
 */

public abstract class BasePresenter<V extends IBaseView> {

    public V mView;

    public BasePresenter(V view) {
        this.mView = view;
    }

    public void detach() {
        mView = null;
    }

    public abstract void cancelHttp();
}
