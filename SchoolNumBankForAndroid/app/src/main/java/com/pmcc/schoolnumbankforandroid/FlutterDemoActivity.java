package com.pmcc.schoolnumbankforandroid;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.pmcc.schoolnumbankforandroid.common.base.BaseActivity;
import com.pmcc.schoolnumbankforandroid.common.base.BasePresenter;
import com.pmcc.schoolnumbankforandroid.utils.FlutterPluginJumpToAct;

import io.flutter.facade.Flutter;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.view.FlutterView;

public class FlutterDemoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flutter);
        FlutterView flutterView = Flutter.createView(this, getLifecycle(), "route1");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        addContentView(flutterView, layoutParams);


    }
//
//    @Override
//    protected BasePresenter createPresenter() {
//        return null;
//    }
//
//    @Override
//    public boolean setNoScreenFit() {
//        return false;
//    }
//
//    @Override
//    public int getLayoutResID() {
//        return R.layout.activity_flutter;
//    }
//
//    @Override
//    protected void initView() throws Exception {
////        FlutterView flutterView = Flutter.createView(this, getLifecycle(), "route1");
////        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
////        addContentView(flutterView, layoutParams);
//
//        registerCustomPlugin(flutterView.getPluginRegistry());
//    }
//    private static void registerCustomPlugin(PluginRegistry registrar) {
//        FlutterPluginJumpToAct.registerWith(registrar.registrarFor(FlutterPluginJumpToAct.CHANNEL));
//       // FlutterPluginCounter.registerWith(registrar.registrarFor(FlutterPluginCounter.CHANNEL));
//    }

}
