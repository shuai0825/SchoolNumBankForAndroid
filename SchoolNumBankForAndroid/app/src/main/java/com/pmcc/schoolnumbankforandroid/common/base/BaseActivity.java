package com.pmcc.schoolnumbankforandroid.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.pmcc.schoolnumbankforandroid.common.utils.ActivityCollector;
import com.pmcc.schoolnumbankforandroid.common.utils.ScreenUtils;
import com.pmcc.schoolnumbankforandroid.common.utils.StatusBarUtil;
import com.pmcc.schoolnumbankforandroid.common.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;

/**
 * Created by ${zhangshuai} on 2018/9/10.
 * 2751157603@qq.com
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMyConfig();
    }

    private void initMyConfig() {
        ActivityCollector.addActivity(this.getClass(), this);
        mPresenter = createPresenter();
        if (!setNoScreenFit()) {
            ScreenUtils.setCustomDensity(this);
        }

        setContentView(getLayoutResID());
        ButterKnife.bind(this);
        try {
            initData();
            initView();
            initListener();
        } catch (Exception e) {
            //异常处理
            showToast(e.getMessage());
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }

    /**
     * 消息提示语句
     *
     * @param message
     */
    protected void showToast(String message) {
        ToastUtils.showToast(message);
    }

    /**
     * 设置mvp
     *
     * @return
     */
    protected abstract T createPresenter();

    /**
     * 是否采用屏幕适配
     *
     * @return
     */
    public abstract boolean setNoScreenFit();


    /**
     * 设置布局
     *
     * @return
     */
    public abstract int getLayoutResID();
    /**
     * 设置标题颜色
     *
     * @return
     */
    public  void setStatusBarColor(int color){
        StatusBarUtil.setColorStatusBar(this,color);
    };

    /**
     * 初始化数据
     *
     * @throws Exception
     */
    protected void initData() throws Exception {

    }

    /**
     * 初始化界面
     *
     * @throws Exception
     */
    protected void initView() throws Exception {

    }

    /**
     * 设置监听
     *
     * @throws Exception
     */
    protected void initListener() throws Exception {

    }

    /**
     * 注册订阅者
     *
     * @param subscribe
     */
    public void registerEventBus(Object subscribe) {
        if (!isEventBusRegisted(subscribe)) {
            EventBus.getDefault().register(subscribe);
        }
    }

    /**
     * 取消注册
     *
     * @param subscribe
     */
    public void unregisterEventBus(Object subscribe) {
        if (isEventBusRegisted(subscribe)) {
            EventBus.getDefault().unregister(subscribe);
        }
    }

    /**
     * 是否注册过
     *
     * @param subscribe
     * @return
     */
    public boolean isEventBusRegisted(Object subscribe) {
        return EventBus.getDefault().isRegistered(subscribe);
    }
}
