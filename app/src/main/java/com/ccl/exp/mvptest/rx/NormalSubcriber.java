package com.ccl.exp.mvptest.rx;

import android.content.Context;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Created by ccl on 2017/11/4.
 * 普通的toast提示
 */

public abstract class NormalSubcriber<T> implements Subscriber<T> {

    private String tag = "nomral";
    private boolean isShowLoading = true;
    private Context mContext;

    /**
     * 正常网络请求Subscriber
     * @param isShowLoading 是否显示dialog
     * @param context 当前窗口的context 注意不做其他事情防止泄露
     * @param tag 请求标注 用于取消请求
     */
    public NormalSubcriber(boolean isShowLoading, Context context, String tag) {
        this.isShowLoading = isShowLoading;
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
