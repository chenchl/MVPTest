package com.ccl.exp.mvptest.ui.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.ccl.exp.mvptest.utils.AppManager;
import com.ccl.exp.mvptest.utils.LogUtil;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ccl on 2017/11/3.
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseActivity {


    private Unbinder unbinder;
    protected boolean needEventBus = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initBefore();
        super.onCreate(savedInstanceState);
        //沉浸式布局
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0 全透明状态栏
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4 全透明状态栏
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        setContentView(initXmlId());
        unbinder = ButterKnife.bind(this);

        AppManager.getInstance().addActivity(this);
        initView();
        //initdata();
        if (needEventBus)
            EventBus.getDefault().register(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        initdata();
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.i(this, "onResume");
        resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.i(this, "onDestroy");
        if (needEventBus)
            EventBus.getDefault().unregister(this);
        if (unbinder != null) {
            unbinder.unbind();
        }
        AppManager.getInstance().removeActivity(this);
    }
}
