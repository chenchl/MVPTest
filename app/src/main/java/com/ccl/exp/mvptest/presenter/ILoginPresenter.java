package com.ccl.exp.mvptest.presenter;

import com.ccl.exp.mvptest.net.params.PostParams;

/**
 * Created by ccl on 2017/11/2.
 */

public interface ILoginPresenter {
    void clear();

    void doLogin(String name, String passwd, int force);

    String getName();

    String getPasswd();

    void setProgressBarVisiblity(int visiblity);

    void toLogin(PostParams loginInfo);

}
