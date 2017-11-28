package com.ccl.exp.mvptest.dagger.component;

import com.ccl.exp.mvptest.dagger.module.LoginActivityModule;
import com.ccl.exp.mvptest.ui.activity.MainActivity;

import dagger.Component;

/**
 * Created by ccl on 2017/11/28.
 */
@Component(modules = LoginActivityModule.class)
public interface LoginActivityComponent {

    void inject(MainActivity mainActivity);
}
