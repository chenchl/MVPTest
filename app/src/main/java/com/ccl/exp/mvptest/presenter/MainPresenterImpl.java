package com.ccl.exp.mvptest.presenter;

import android.text.Html;

import com.ccl.exp.mvptest.global.GlobalApplication;
import com.ccl.exp.mvptest.presenter.inter.IMainPresenter;
import com.ccl.exp.mvptest.utils.AppManager;
import com.ccl.exp.mvptest.utils.SPUtils;
import com.ccl.exp.mvptest.utils.ToastUtils;
import com.ccl.exp.mvptest.view.IMainView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ccl on 2017/11/29.
 */

public class MainPresenterImpl extends BasePresenter<IMainView> implements IMainPresenter {

    private boolean isExit = false;

    public MainPresenterImpl(IMainView view) {
        super(view);
    }

    @Override
    public void exitBy2Click() {
        Timer tExit = null;
        if (isExit == false) {
            isExit = true; // 准备退出
            boolean flag = SPUtils.getInstance().getTheme();
            if (flag) {
                ToastUtils.showToast(mView.getContext(), "再按一次退出程序");
            } else {
                String toast = "<font color='#8F8F8F'>再按一次退出程序</font>";
                ToastUtils.showToast(mView.getContext(), Html.fromHtml(toast));
            }

            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; // 取消退出
                }
            }, 3000);

        } else {
            AppManager.getInstance().AppExit(GlobalApplication.getInstance(), false);
        }
    }

    @Override
    public void cancelHttp() {

    }

    @Override
    public void initData() {

    }
}
