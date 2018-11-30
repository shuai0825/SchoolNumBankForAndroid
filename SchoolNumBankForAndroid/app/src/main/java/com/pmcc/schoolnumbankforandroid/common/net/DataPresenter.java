package com.pmcc.schoolnumbankforandroid.common.net;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.pmcc.schoolnumbankforandroid.common.base.BaseActivity;
import com.pmcc.schoolnumbankforandroid.common.base.BasePresenter;
import com.pmcc.schoolnumbankforandroid.common.base.MyApp;
import com.pmcc.schoolnumbankforandroid.common.utils.LogUtils;
import com.pmcc.schoolnumbankforandroid.widgets.MyprogressDialog;

import java.io.File;

/**
 * Created by ${zhangshuai} on 2018/9/10.
 * 2751157603@qq.com
 * presenter层数据处理，继承父类只能一个，实现可以多个
 */
public class DataPresenter extends BasePresenter<DataView> {

    private MyprogressDialog myProgressDialog;

    /**
     * 初始化，并绑定view
     *
     * @param view
     */
    public DataPresenter(DataView view) {
        super(view);
        if (view instanceof BaseActivity) {
            myProgressDialog = new MyprogressDialog((BaseActivity) view);
        }
    }

    /**
     * get请求,加载框
     *
     * @param url
     * @param params
     */
    public void getDataInfo(String url, HttpParams params, String msg) {
        if (msg != null && myProgressDialog != null) {
            myProgressDialog.showMsg(msg);
        }
        getDataInfo(url, params);
    }

    /**
     * get请求
     *
     * @param url
     * @param params
     */
    public void getDataInfo(String url, HttpParams params) {
        LogUtils.d(JSON.toJSONString(params));
        getDataModel(url, params, new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                closeProgress();

            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);
                closeProgress();
            }
        });
    }

    /**
     * post请求，加载框
     * @param url
     * @param params
     * @param msg
     */
    public void postDataInfo(String url, HttpParams params, String msg) {
        if (msg != null && myProgressDialog != null) {
            myProgressDialog.showMsg(msg);
        }
        postDataInfo(url, params);
    }
    /**
     * post请求
     *
     * @param url
     * @param params
     */
    public void postDataInfo(String url, HttpParams params) {
        myProgressDialog.show();
        postDataModel(url, params, new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {//200，访问正常
                Log.d("%s", response.code() + "/" + response.body());
                closeProgress();
            }

            @Override
            public void onError(Response<String> response) {//-1,(没有网络,超时）
                super.onError(response);
                Log.d("%s", response.code() + "/" + response.getException());
                closeProgress();
            }

            @Override
            public void uploadProgress(Progress progress) {
                super.uploadProgress(progress);
            }
        });
    }

    /**
     * 下载
     *
     * @param url
     */
    public void downDataInfo(String url, String fileName) {
        downDataModel(url, new FileCallback(fileName) {
            @Override
            public void onSuccess(Response<File> response) {
                Log.d("%s", "success"+response.code() + "/" + response.body());
            }

            @Override
            public void onError(Response<File> response) {
                super.onError(response);
                Log.d("%s", "error"+response.code() + "/" + response.getException());
            }

            @Override
            public void downloadProgress(Progress progress) {
                super.downloadProgress(progress);
                Log.d("%s", progress.fraction+"/"+progress.totalSize+"/"+progress.currentSize);
            }
        });
    }

    /**
     * 关闭加载框
     */
    private void closeProgress() {
        if (myProgressDialog != null) {
            myProgressDialog.dismiss();
        }
    }
}
