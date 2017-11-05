package com.ccl.exp.mvptest.view;

import android.content.Context;

/**
 * Created by ccl on 2017/11/3.
 */

public interface IBaseView {
    void onError(String msg);

    Context getContext();
}
