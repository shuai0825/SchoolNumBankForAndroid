package com.pmcc.schoolnumbankforandroid.common.base;

import com.pmcc.schoolnumbankforandroid.common.net.DataModel;

/**
 * Created by ${zhangshuai} on 2018/9/10.
 * 2751157603@qq.com
 * 将view层绑定到presenter
 */
public class BasePresenter<T> extends DataModel{
    protected T mView;

    /**
     * 初始化，并绑定view
     * @param view
     */
    public BasePresenter(T view){
        attachView(view);
    }

    /**
     * 绑定view
     * @param view
     */
    private void attachView(T view) {
        mView=view;
    }

    /**
     * 分离view
     */
    public void detachView(){
        mView=null;
    }
}
