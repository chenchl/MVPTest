package com.ccl.exp.mvptest.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.lang.reflect.Method;

/**
 * Created by ccl on 2017/11/4.
 */

public class CommonUtils {

    /**
     * 获取系统序列号
     *
     * @return
     */
    public static String getAndroidID() {
        String serialnum = "";
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("get", String.class, String.class);
            serialnum = (String) (get.invoke(c, "ro.serialno", "unknown"));
            return serialnum;
        } catch (Exception ignored) {
            return serialnum;
        }
    }

    /**
     * 获取版本号
     *
     * @return 当前应用的版本号
     */
    public static String getVersion(Context ctx) {
        try {
            PackageManager manager = ctx.getPackageManager();
            PackageInfo info = manager.getPackageInfo(ctx.getPackageName(), 0);
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return "1.0";
        }
    }
}
