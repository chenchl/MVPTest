package com.ccl.exp.mvptest.dagger.module;

import com.ccl.exp.mvptest.presenter.LoginPresenterImpl;
import com.ccl.exp.mvptest.view.ILoginView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ccl on 2017/11/28.
 */
@Module
public class LoginActivityModule {

    private ILoginView iLoginView;

    public LoginActivityModule(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    @Provides
    LoginPresenterImpl provideLoginPersenter() {
        return new LoginPresenterImpl(iLoginView);
    }
}
