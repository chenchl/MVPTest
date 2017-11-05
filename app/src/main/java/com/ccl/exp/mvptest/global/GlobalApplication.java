package com.ccl.exp.mvptest.global;

import android.app.Application;

import com.ccl.exp.mvptest.utils.LogUtil;

/**
 * Created by ccl on 2016/9/12.
 * Application
 */
public class GlobalApplication extends Application {
    private static GlobalApplication instance;

    /**
     * 获取全局application实例
     *
     * @return
     */
    public static GlobalApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        /*if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        install = LeakCanary.install(this);*/
        instance = this;
        LogUtil.e(this, "app onCreate");
    }
}
