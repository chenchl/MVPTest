package com.ccl.exp.mvptest.rx;


import android.support.v4.util.ArrayMap;

import org.reactivestreams.Subscription;

import java.util.Set;

/**
 * Created by ccl on 2017/11/4.
 * 请求管理 用于取消请求
 */

public class RxSubscriptionManager {

    private static volatile RxSubscriptionManager sInstance = null;

    private ArrayMap<Object, Subscription> maps;

    public static RxSubscriptionManager getsInstance() {

        if (sInstance == null) {
            synchronized (RxSubscriptionManager.class) {
                if (sInstance == null) {
                    sInstance = new RxSubscriptionManager();
                }
            }
        }
        return sInstance;
    }

    private RxSubscriptionManager() {
        maps = new ArrayMap<>();
    }

    public void add(Object tag, Subscription subscription) {
        if (maps == null)
            maps = new ArrayMap<>();
        maps.put(tag, subscription);
    }


    public void remove(Object tag) {
        if (maps != null && !maps.isEmpty())
            maps.remove(tag);
    }

    public void removeAll() {
        if (maps != null && !maps.isEmpty())
            maps.clear();
    }

    public void cancel(Object tag) {
        if (maps == null)
            return;
        if (maps != null && maps.isEmpty())
            return;
        if (maps != null && maps.get(tag) == null)
            return;
        maps.get(tag).cancel();
        maps.remove(tag);
    }

    public void cancelAll() {
        if (maps == null)
            return;
        if (maps != null && maps.isEmpty()) {
            return;
        }
        Set<Object> keys = maps.keySet();
        for (Object apiKey : keys) {
            cancel(apiKey);
        }
    }
}
