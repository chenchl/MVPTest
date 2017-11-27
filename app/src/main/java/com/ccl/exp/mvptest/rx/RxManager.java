package com.ccl.exp.mvptest.rx;

import com.ccl.exp.mvptest.net.ApiException;
import com.ccl.exp.mvptest.net.response.BaseResponse;

import org.reactivestreams.Subscriber;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by ccl on 2017/11/4.
 * 封装rxjava retrofit请求
 */

public class RxManager {

    private static volatile RxManager instance;

    private RxManager() {
    }

    public static RxManager getInstance() {
        if (instance == null) {
            synchronized (RxManager.class) {
                if (instance == null)
                    instance = new RxManager();
            }
        }
        return instance;
    }

    public <T> void doSubscribe(Flowable<T> flowable, Subscriber<T> subscriber) {
        flowable.compose(RxSchedulers.io_main())
                .subscribe(subscriber);
    }

    public <T> void doSubscribe1(Flowable<BaseResponse<T>> flowable, Subscriber<T> subscriber) {
        flowable.map(new Function<BaseResponse<T>, T>() {
            @Override
            public T apply(@NonNull BaseResponse<T> tBaseResponse) throws Exception {
                if (tBaseResponse.isResponseOK()) {
                    return tBaseResponse.getData();
                } else {
                    throw new ApiException(tBaseResponse.getMessage());
                }
            }
        }).compose(RxSchedulers.io_main()).subscribe(subscriber);
    }
}
