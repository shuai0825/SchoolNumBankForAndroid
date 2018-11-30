package com.pmcc.schoolnumbankforandroid.common.net;

/**
 * Created by ${zhangshuai} on 2018/9/10.
 * 2751157603@qq.com
 */
public interface DataView {
    /**
     * 数据请求成功
     * @param url
     * @param info
     */
    void showSuccess(String url, String info);

    /**
     * 数据请求失败
     * @param url
     * @param code
     * @param msgInfo
     */
    void showError(String url, String code, String msgInfo);//错误信息
}
