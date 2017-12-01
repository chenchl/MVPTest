package com.ccl.exp.mvptest.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.ccl.exp.mvptest.global.GlobalApplication;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
     * 获取版本名称
     *
     * @return
     */
    public static String getVersion() {
        try {
            PackageManager manager = GlobalApplication.getInstance().getPackageManager();
            PackageInfo info = manager.getPackageInfo(GlobalApplication.getInstance().getPackageName(), 0);
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return "1.0";
        }
    }

    /**
     * 获取版本号
     *
     * @return
     */
    public static int getVersionCode() {
        try {
            PackageManager pm = GlobalApplication.getInstance().getPackageManager();
            int versioncode = 1;
            PackageInfo pi = null;
            pi = pm.getPackageInfo(GlobalApplication.getInstance().getPackageName(), 0);
            versioncode = pi.versionCode;
            return versioncode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 1;
        }
    }

    /**
     * 判断字符串是否仅为数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    /**
     * 判断字符串中是否包含中文
     *
     * @param str
     * @return
     */
    public static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    /**
     * 获取html文本内容
     *
     * @param inputString
     * @return
     */
    public static String Html2Text(String inputString) {
        String htmlStr = inputString; // 含html标签的字符串
        String textStr = "";
        Pattern p_script;
        Matcher m_script;
        Pattern p_style;
        Matcher m_style;
        Pattern p_html;
        Matcher m_html;
        Pattern p_enter;
        Matcher m_enter;
        try {
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
            // }
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
            // }
            String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
            String regEx_enter = "\\s*|\t|\r|\n"; // 定义HTML制表符的正则表达式

            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); // 过滤script标签

            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); // 过滤style标签

            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); // 过滤html标签

            p_enter = Pattern.compile(regEx_enter, Pattern.CASE_INSENSITIVE);
            m_enter = p_enter.matcher(htmlStr);
            htmlStr = m_enter.replaceAll(""); // 过滤html标签

            textStr = htmlStr;

        } catch (Exception e) {
            System.err.println("Html2Text: " + e.getMessage());
        } finally {
            return textStr;// 返回文本字符串
        }
    }

    /**
     * 复制内容到剪切板
     *
     * @param context
     * @param txt
     */
    public static void copyTxt(Context context, String txt) {
        //获取剪贴板管理器：
        ClipboardManager cm = (ClipboardManager) GlobalApplication.getInstance().getSystemService(Context.CLIPBOARD_SERVICE);
        // 创建普通字符型ClipData
        ClipData mClipData = ClipData.newPlainText("Label", txt);
        // 将ClipData内容放到系统剪贴板里。
        cm.setPrimaryClip(mClipData);
        ToastUtils.showToast(context, "链接已复制到剪切板");
    }
}
