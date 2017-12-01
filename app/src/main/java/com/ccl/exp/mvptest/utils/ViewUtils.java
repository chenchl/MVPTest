package com.ccl.exp.mvptest.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.ccl.exp.mvptest.global.GlobalApplication;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by ccl on 2017/11/30.
 */

public class ViewUtils {

    /**
     * 根据dimens文件获取px值
     *
     * @param ResId
     * @return
     */
    public static int getPx(int ResId) {

        return GlobalApplication.getInstance().getResources().getDimensionPixelOffset(ResId);
    }

    /**
     * dp转px
     *
     * @param dipValue
     * @return
     */
    public static int dp2px(float dipValue) {
        final float scale = GlobalApplication.getInstance().getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 获取是否有NavigationBar
     *
     * @return
     */
    public static boolean isHaveNavigationBar() {
        boolean isHave = false;
        try {
            Class systemPropertiesClass = Class.forName("android.os.SystemProperties");
            Method m = systemPropertiesClass.getMethod("get", String.class);
            String navBarOverride = (String) m.invoke(systemPropertiesClass, "qemu.hw.mainkeys");
            if ("1".equals(navBarOverride)) {
                isHave = false;
            } else if ("0".equals(navBarOverride)) {
                isHave = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return isHave;
        }
    }

    /**
     * 获取屏幕的宽度
     *
     * @return
     */
    public static int getWindowsWidth() {
        WindowManager wm = (WindowManager) GlobalApplication.getInstance().getSystemService(Context.WINDOW_SERVICE);
        int height = 0;
        if (wm != null)
            height = wm.getDefaultDisplay().getWidth();
        return height;
    }

    /**
     * 获取屏幕的高度
     *
     * @return
     */
    public static int getWindowsHeight() {
        WindowManager wm = (WindowManager) GlobalApplication.getInstance().getSystemService(Context.WINDOW_SERVICE);
        int height = 0;
        if (wm != null)
            height = wm.getDefaultDisplay().getHeight();
        return height;
    }

    /**
     * 获取屏幕亮度值
     *
     * @return 0-255
     */
    public static int getScreenBrightness() {
        int val = 255;
        try {
            ContentResolver contentResolver = GlobalApplication.getInstance().getContentResolver();
            int defVal = 125;
            val = Settings.System.getInt(contentResolver,
                    Settings.System.SCREEN_BRIGHTNESS, defVal);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return val;
        }


    }

    /**
     * 设置亮度值
     *
     * @param bright
     */
    public static void setScreenBrightness(int bright) {

        try {
            ContentResolver contentResolver = GlobalApplication.getInstance().getContentResolver();
            //设置屏幕亮度调节模式为手动
            int mode = Settings.System.getInt(contentResolver,
                    Settings.System.SCREEN_BRIGHTNESS_MODE);
            if (mode == Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC) {
                Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS_MODE,
                        Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
            }
            //设置亮度值
            int value = bright; // 设置亮度值为255
            Settings.System.putInt(contentResolver,
                    Settings.System.SCREEN_BRIGHTNESS, value);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取虚拟按键高度
     *
     * @return
     */
    public static int getVirtualButtonHeight(Activity activity) {
        int virtualHeight = -1;
        if (activity != null) {
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int winHeight = activity.getWindow().getDecorView().getHeight();
            virtualHeight = winHeight - rect.bottom;
        }
        return virtualHeight;
    }

    /**
     * 动态的设置状态栏  实现沉浸式状态栏
     *
     * @param activity
     * @param bar
     */
    public static void initState(Activity activity, View bar) {

        //当系统版本为4.4或者4.4以上时可以使用沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
//            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            //
//            LinearLayout linear_bar = (LinearLayout) activity.findViewById(R.id.ll_bar);
            bar.setVisibility(View.VISIBLE);
            //获取到状态栏的高度
            int statusHeight = getStatusBarHeight();
            //动态的设置隐藏布局的高度
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) bar.getLayoutParams();
            params.height = statusHeight;
            bar.setLayoutParams(params);
        }
    }

    /**
     * 通过反射的方式获取状态栏高度
     *
     * @return
     */
    public static int getStatusBarHeight() {
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            return GlobalApplication.getInstance().getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
