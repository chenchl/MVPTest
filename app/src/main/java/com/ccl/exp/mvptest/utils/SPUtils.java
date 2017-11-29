package com.ccl.exp.mvptest.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.ccl.exp.mvptest.global.GlobalApplication;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by ccl on 2017/11/29.
 * 本地存储工具类
 */

public class SPUtils {

    private static Context context;
    private volatile static SPUtils instance;

    private SPUtils(Context context) {
        this.context = context;
    }

    public static SPUtils getInstance() {
        if (instance == null) {
            synchronized (SPUtils.class) {
                if (instance == null) {
                    instance = new SPUtils(GlobalApplication.getInstance());
                }
            }
        }
        return instance;
    }

    /**
     * 根据内容取得编辑器
     *
     * @param sharedType
     * @return
     */
    public Editor getEditor(SharedType sharedType) {
        if (context == null)
            context = GlobalApplication.getInstance();
        return context.getSharedPreferences(sharedType.getKey(),
                sharedType.getMode()).edit();
    }

    /**
     * 根据内容取得share对象用于读取数据
     *
     * @param sharedType
     * @return
     */
    public SharedPreferences getSharedPreferences(SharedType sharedType) {
        if (context == null)
            context = GlobalApplication.getInstance();
        return context.getSharedPreferences(sharedType.getKey(),
                sharedType.getMode());
    }

    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     *
     * @param sharedType
     * @param key
     * @param object
     */
    public void put(SharedType sharedType, String key, Object object) {
        if (object != null) {
            Editor editor = getEditor(sharedType);
            if (object instanceof String) {
                editor.putString(key, (String) object);
            } else if (object instanceof Integer) {
                editor.putInt(key, (Integer) object);
            } else if (object instanceof Boolean) {
                editor.putBoolean(key, (Boolean) object);
            } else if (object instanceof Float) {
                editor.putFloat(key, (Float) object);
            } else if (object instanceof Long) {
                editor.putLong(key, (Long) object);
            } else {
                editor.putString(key, object.toString());
            }
            SharedPreferencesCompat.apply(editor);
        }
    }

    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     *
     * @param sharedType
     * @param key
     * @param defaultObject
     * @return
     */
    public Object get(SharedType sharedType, String key, Object defaultObject) {
        SharedPreferences sp = getSharedPreferences(sharedType);
        if (defaultObject instanceof String) {
            return sp.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return sp.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sp.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sp.getLong(key, (Long) defaultObject);
        }
        return null;
    }

    /**
     * 移除某个key值已经对应的值
     *
     * @param sharedType
     * @param key
     */
    public void remove(SharedType sharedType, String key) {
        Editor editor = getEditor(sharedType);
        editor.remove(key);
        SharedPreferencesCompat.apply(editor);
    }

    /**
     * 清除所有数据
     *
     * @param sharedType
     */
    public void clear(SharedType sharedType) {
        Editor editor = getEditor(sharedType);
        editor.clear();
        SharedPreferencesCompat.apply(editor);
    }

    /**
     * 查询某个key是否已经存在
     *
     * @param sharedType
     * @param key
     * @return
     */
    public boolean contains(SharedType sharedType, String key) {
        SharedPreferences sp = getSharedPreferences(sharedType);
        return sp.contains(key);
    }

    /**
     * 返回所有的键值对
     *
     * @param sharedType
     * @return
     */
    public Map<String, ?> getAll(SharedType sharedType) {
        SharedPreferences sp = getSharedPreferences(sharedType);
        return sp.getAll();
    }


    /**
     * 创建一个解决SharedPreferencesCompat.apply方法的一个兼容类
     *
     * @author zhy
     */
    private static class SharedPreferencesCompat {
        private static final Method sApplyMethod = findApplyMethod();

        /**
         * 反射查找apply的方法
         *
         * @return
         */
        @SuppressWarnings({"unchecked", "rawtypes"})
        private static Method findApplyMethod() {
            try {
                Class clz = SharedPreferences.Editor.class;
                return clz.getMethod("apply");
            } catch (NoSuchMethodException e) {
            }

            return null;
        }

        /**
         * 如果找到则使用apply执行，否则使用commit
         *
         * @param editor
         */
        public static void apply(SharedPreferences.Editor editor) {
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor);
                    return;
                }
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
            editor.commit();
        }
    }

}
