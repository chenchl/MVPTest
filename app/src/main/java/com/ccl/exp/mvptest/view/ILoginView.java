package com.ccl.exp.mvptest.view;

/**
 * Created by ccl on 2017/11/2.
 */

public interface ILoginView extends IBaseView{
    void onClearText();

    void onLoginResult(Boolean result, String code);

    void onSetProgressBarVisibility(int visibility);
}
