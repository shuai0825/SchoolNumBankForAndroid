package com.pmcc.schoolnumbankforandroid.common.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

import com.pmcc.schoolnumbankforandroid.common.base.MyApp;


public class UIUtils {
    /**
     * dip转换px
     */
    public static int dip2px(int dip) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }

    /**
     * pxz转换dip
     */

    public static int px2dip(int px) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }

    /**
     * 根据string-array id 获取 数组
     */
    public static String[] getStringArray(int id) {
        return getResource().getStringArray(id);
    }

    public static Resources getResource() {
        return getContext().getResources();
    }

    public static Context getContext() {
        return MyApp.getInstance();
    }

    /**
     * 根据Layout id 获取 view 对象
     *
     * @param layout
     * @return
     */
    public static View inflate(int layout) {
        return View.inflate(getContext(), layout, null);
    }

    public static Drawable getDrawable(int id) {
        return getResource().getDrawable(id);
    }

    public static int getColor(int id) {
        return getResource().getColor(id);
    }

    public static int getDimention(int id) {
        return (int) getResource().getDimension(id);
    }


    /**
     * 通过id 获取string
     *
     * @param id
     * @return
     */
    public static String getString(int id) {
        return getResource().getString(id);
    }

    /**
     * 代码中设置间距
     *
     * @param v
     * @param l
     * @param t
     * @param r
     * @param b
     */
    public static void setMargins(View v, int l, int t, int r, int b) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(l, t, r, b);
            v.requestLayout();
        }
    }




}
