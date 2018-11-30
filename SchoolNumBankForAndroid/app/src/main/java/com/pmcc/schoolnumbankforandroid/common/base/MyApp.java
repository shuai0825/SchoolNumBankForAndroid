package com.pmcc.schoolnumbankforandroid.common.base;

import android.app.Application;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.pmcc.schoolnumbankforandroid.common.utils.NeverCrash;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by ${zhangshuai} on 2018/9/10.
 * 2751157603@qq.com
 */
public class MyApp extends Application {
    private static MyApp mMyApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mMyApp = this;
        initCrash();
        initOkGo();
    }


    public static MyApp getInstance() {
        return mMyApp;
    }

    /**
     * 初始化异常捕获
     */
    private void initCrash() {
        NeverCrash.init(new NeverCrash.CrashHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                //异常处理操作
            }
        });
    }

    /**
     * 初始化网络请求
     */
    private void initOkGo() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(ConstantConfig.connectTime, TimeUnit.MILLISECONDS);
        OkGo.getInstance().init(this)                       //必须调用初始化
                .setOkHttpClient(builder.build())               //建议设置OkHttpClient，不设置将使用默认的
                .setCacheMode(CacheMode.NO_CACHE)               //全局统一缓存模式，默认不使用缓存，可以不传
                //.setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)   //全局统一缓存时间，默认永不过期，可以不传
                .setRetryCount(3);                               //全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0
        //.addCommonHeaders(headers)                      //全局公共头
        //.addCommonParams(params);                       //全局公共参数
    }


}
