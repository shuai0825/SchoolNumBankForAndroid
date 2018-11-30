package com.pmcc.schoolnumbankforandroid.common.utils;

import android.app.Activity;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by ${zhangshuai} on 2018/6/8.
 * 2751157603@qq.com
 * activity的管理类
 */
public class ActivityCollector {
    public static HashMap<Class<?>, Activity> activities = new LinkedHashMap<>();

    /**
     * 判断当前activity是否存在
     * @param clz
     * @return
     */
    public static boolean isActivityExist(Class<?> clz) {
        boolean res;
        Activity activity = activities.get(clz);
        if (activity == null) {
            res = false;
        } else {
            if (activity.isFinishing() || activity.isDestroyed()) {
                res = false;
            } else {
                res = true;
            }
        }

        return res;
    }

    /**
     * 添加当前activity
     *
     * @param activity
     * @param clz
     */
    public static void addActivity(Class<?> clz, Activity activity) {
        activities.put(clz, activity);
    }

    /**
     * 退出，在集合中移除当前activity
     *
     * @param activity
     */
    public static void removeActivity(Activity activity) {
        if (activities.containsValue(activity)) {
            activities.remove(activity.getClass());
        }
    }

    /**
     * 移除activity,代替finish
     */
    public static void finishActivity(Class<?> clz) {
        if (activities.containsKey(clz)) {
            activities.get(clz).finish();
            activities.remove(clz);
        }
    }

    /**
     * 退出所有activity
     */
    public static void removeAllActivity() {
        if (activities != null && activities.size() > 0) {
            Set<Map.Entry<Class<?>, Activity>> sets = activities.entrySet();
            for (Map.Entry<Class<?>, Activity> s : sets) {
                if (!s.getValue().isFinishing()) {
                    s.getValue().finish();
                }
            }
        }
        activities.clear();
    }
}
