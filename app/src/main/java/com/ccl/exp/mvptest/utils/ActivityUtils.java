package com.ccl.exp.mvptest.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.ccl.exp.mvptest.R;

/**
 * Created by ccl on 2017/11/29.
 */

public class ActivityUtils {

    /**
     * activity跳转
     *
     * @param fromactivity
     * @param toActivity
     * @param isFinish
     */
    public static void toActivity(@NonNull Activity fromactivity, Class toActivity, boolean isFinish) {
        Intent intent = new Intent(fromactivity, toActivity);
        fromactivity.startActivity(intent);
        //进入退出动画
        fromactivity.overridePendingTransition(R.anim.anim_enter, R.anim.anim_exit);
        if (isFinish)
            fromactivity.finish();
    }

    /**
     * activity跳转
     *
     * @param fromactivity
     * @param toActivity
     * @param extras
     * @param isFinish
     */
    public static void toActivity(@NonNull Activity fromactivity, Class toActivity, Bundle extras, boolean isFinish) {
        Intent intent = new Intent(fromactivity, toActivity);
        intent.putExtras(extras);
        fromactivity.startActivity(intent);
        //进入退出动画
        fromactivity.overridePendingTransition(R.anim.anim_enter, R.anim.anim_exit);
        if (isFinish)
            fromactivity.finish();
    }

    /**
     * activity跳转（返回）
     *
     * @param fromactivity
     * @param toActivity
     * @param extras
     * @param requestCode
     */
    public static void toActivityForResult(@NonNull Activity fromactivity, Class toActivity, Bundle extras, int requestCode) {
        Intent intent = new Intent(fromactivity, toActivity);
        intent.putExtras(extras);
        fromactivity.startActivityForResult(intent, requestCode);
        //进入退出动画
        fromactivity.overridePendingTransition(R.anim.anim_enter, R.anim.anim_exit);
    }
}
