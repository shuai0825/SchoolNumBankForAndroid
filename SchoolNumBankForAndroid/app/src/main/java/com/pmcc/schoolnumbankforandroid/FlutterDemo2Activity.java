package com.pmcc.schoolnumbankforandroid;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.pmcc.schoolnumbankforandroid.utils.ActToFlutterPlugin;
import com.pmcc.schoolnumbankforandroid.utils.FlutterPluginJumpToAct;

import io.flutter.app.FlutterActivity;
import io.flutter.facade.Flutter;
import io.flutter.facade.FlutterFragment;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.GeneratedPluginRegistrant;
import io.flutter.view.FlutterView;

/**
 * Created by ${zhangshuai} on 2018/9/18.
 * 2751157603@qq.com
 */
public class FlutterDemo2Activity extends FlutterActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FlutterView flutterView = getFlutterView();
        flutterView.setInitialRoute("route1");
        GeneratedPluginRegistrant.registerWith(flutterView.getPluginRegistry());
        //ActToFlutterPlugin.registerWith(this.registrarFor(ActToFlutterPlugin.CHANNEL));
        FlutterPluginJumpToAct.registerWith(registrarFor(ActToFlutterPlugin.CHANNEL));
        SharedPreferences sharedPreferences = flutterView.getContext().getSharedPreferences("FlutterSharedPreferences", MODE_PRIVATE);
      //  SharedPreferences    sharedPreferences = getSharedPreferences("FlutterSharedPreferences", MODE_PRIVATE);

        sharedPreferences.edit().putInt("counter", 9)
                .putString("data","android原生储存").commit();

//160944717
        Log.d( "%s",""+sharedPreferences.getString("data","2"));

    }
}
