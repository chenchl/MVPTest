package com.ccl.exp.mvptest.rx;

import android.content.Context;

import com.ccl.exp.mvptest.utils.ToastUtils;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.IOException;

/**
 * Created by ccl on 2017/11/4.
 * 普通的toast提示
 */

public abstract class NormalSubcriber<T> implements Subscriber<T> {

    private String tag = "nomral";
    private boolean isShowLoading = true;
    private Context mContext;

    public NormalSubcriber(boolean isShowLoding, Context context, String tag) {
        this.isShowLoading = isShowLoding;
        mContext = context;
        this.tag = tag;
    }

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);//对应flowable表示不限制发送
        RxSubscriptionManager.getsInstance().add(tag, s);
        if (isShowLoading)
            showLoading();
    }

    /**
     * 显示进度
     */
    private void showLoading() {

    }

    @Override
    public void onNext(T t) {
        onResponse(t);
    }

    @Override
    public void onError(Throwable t) {
        if (t instanceof IOException)
            ToastUtils.showToast(mContext, "网络链接异常");
        else
            ToastUtils.showToast(mContext, t.getMessage());
        cancelLoading();
        _onError(t);
        RxSubscriptionManager.getsInstance().remove(tag);
        mContext = null;//防止内存泄漏
    }

    @Override
    public void onComplete() {
        cancelLoading();
        RxSubscriptionManager.getsInstance().remove(tag);
        mContext = null;//防止内存泄漏
    }

    /**
     * 错误回调
     *
     * @param t
     */
    protected abstract void _onError(Throwable t);

    /**
     * 正常回调
     *
     * @param t
     */
    protected abstract void onResponse(T t);

    private void cancelLoading() {

    }
}
