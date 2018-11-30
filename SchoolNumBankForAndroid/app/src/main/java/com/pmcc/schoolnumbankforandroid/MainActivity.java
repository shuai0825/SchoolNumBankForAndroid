package com.pmcc.schoolnumbankforandroid;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.lzy.okgo.model.HttpParams;
import com.pmcc.schoolnumbankforandroid.common.base.BaseActivity;
import com.pmcc.schoolnumbankforandroid.common.net.DataPresenter;
import com.pmcc.schoolnumbankforandroid.common.net.DataView;
import com.pmcc.schoolnumbankforandroid.common.net.Urls;
import com.pmcc.schoolnumbankforandroid.common.utils.StatusBarUtil;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity<DataPresenter> implements DataView {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    startActivity(new Intent(MainActivity.this, FlutterDemoActivity.class));
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    startActivity(new Intent(MainActivity.this, FlutterDemo2Activity.class));
                    return true;
            }
            return false;
        }
    };


    @Override
    protected DataPresenter createPresenter() {
        return new DataPresenter(this);
    }

    @Override
    public boolean setNoScreenFit() {
        return false;
    }


    @Override
    public int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() throws Exception {
        StatusBarUtil.setTranStatusBar(this);
        HttpParams parap = new HttpParams();
        parap.put("phone", "13673663363");
        parap.put("pwd", "12445");
        mPresenter.postDataInfo(Urls.login, parap);
        Log.d("%s", "" + StatusBarUtil.getStatusBarHeight());//72
        StatusBarUtil.StatusBarLightMode(this);
        // mPresenter.downDataInfo(Urls.loadUrl,"hanyi.apk");

    }

    @Override
    protected void initView() throws Exception {
        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        setRxjava();
//     FlutterView flutterView = Flutter.createView(this, getLifecycle(), "route1");
//        flutterView.getPluginRegistry()
//        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
//        setContentView(flutterView, layoutParams);
    }


    @Override
    public void showSuccess(String url, String info) {


    }

    @Override
    public void showError(String url, String code, String msgInfo) {

    }

    private void setRxjava() {
        Observable.create(new ObservableOnSubscribe<Integer>() {

            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
            }
        })
                .map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return "你好";
            }
        })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.d("%s", "接收数据：" + s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
