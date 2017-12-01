package com.ccl.exp.mvptest.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by ccl on 2017/11/3.
 */

public class ToastUtils {

    private static Toast mToast = null;//全局唯一的Toast

    /**
     * 短Toast 弹窗
     *
     * @param context
     * @param s
     */
    public static void showToast(Context context, CharSequence s) {
        if (mToast == null) {
            mToast = Toast.makeText(context, s, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(s);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    /**
     * 长Toast 弹窗
     *
     * @param context
     * @param s
     */
    public static void showLongToast(Context context, CharSequence s) {
        if (mToast == null) {
            mToast = Toast.makeText(context, s, Toast.LENGTH_LONG);
        } else {
            mToast.setText(s);
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        mToast.show();
    }
}
