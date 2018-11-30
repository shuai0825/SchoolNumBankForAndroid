package com.pmcc.schoolnumbankforandroid.common.net;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;

import java.io.File;
import java.util.Map;

/**
 * Created by ${zhangshuai} on 2018/9/10.
 * 2751157603@qq.com
 * 网络请求,获取数据
 */
public class DataModel{
    /**
     * get请求
     * @param url
     * @param params
     * @param callback
     */
    protected void getDataModel(String url, HttpParams params,StringCallback callback) {
        OkGo.<String>get(url).tag(url).params(params).execute(callback);
    }

    /**
     * post请求
     * @param url
     * @param params
     * @param callback
     */
    protected void postDataModel(String url,HttpParams params,StringCallback callback) {
       OkGo.<String>post(url).tag(url).params(params).execute(callback);
    }

    /**
     * 下载请求
     * @param url
     * @param callback,FileCallback可设置下载地址
     */
    protected void downDataModel(String url,FileCallback callback) {
        OkGo.<File>get(url).tag(url)
               .execute(callback);
    }
}

