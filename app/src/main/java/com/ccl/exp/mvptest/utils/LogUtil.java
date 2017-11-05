package com.ccl.exp.mvptest.utils;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.ccl.exp.mvptest.global.GlobalApplication;

import java.io.IOException;


/**
 * log输出
 *
 * @author ccl
 */
public class LogUtil {

    public static boolean isDebug = getIsLogEnable(); // LOG开关

    public static void d(String tag, String msg) {
        if (isDebug) {
            Log.d(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (isDebug) {
            Log.e(tag, msg);
        }
    }

    public static void d(Object object, String msg) {
        if (isDebug) {
            Log.d(object.getClass().getSimpleName(), msg);
        }
    }

    public static void e(Object object, String msg) {
        if (isDebug) {
            Log.e(object.getClass().getSimpleName(), msg);
        }
    }

    public static void i(String tag, String msg) {
        if (isDebug) {
            Log.i(tag, msg);
        }
    }

    public static void i(Object object, String msg) {
        if (isDebug) {
            Log.i(object.getClass().getSimpleName(), msg);
        }
    }

    public static boolean getIsLogEnable() {
        ApplicationInfo appInfo = null;
        try {
            appInfo = GlobalApplication.getInstance().getPackageManager().
                    getApplicationInfo(GlobalApplication.getInstance().getPackageName(),
                            PackageManager.GET_META_DATA);
            int ENVIRONMENT = appInfo.metaData.getInt("LOG_ENABLE");
            return ENVIRONMENT == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
