package com.ccl.exp.mvptest.rx;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ccl on 2017/11/5.
 */

public class RxSchedulers {

    public static FlowableTransformer io_main() {
        return new FlowableTransformer() {
            @Override
            public Publisher apply(@NonNull Flowable upstream) {
                return upstream.subscribeOn(Schedulers.io()).
                        unsubscribeOn(Schedulers.io()).
                        observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
