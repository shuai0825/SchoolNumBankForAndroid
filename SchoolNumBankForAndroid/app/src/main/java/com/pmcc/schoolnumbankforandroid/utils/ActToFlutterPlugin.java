package com.pmcc.schoolnumbankforandroid.utils;

import android.app.Activity;

import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.PluginRegistry;

/**
 * Created by ${zhangshuai} on 2018/9/19.
 * 2751157603@qq.com
 */
public class ActToFlutterPlugin implements EventChannel.StreamHandler {
    public static String CHANNEL = "com.jzhu.counter/plugin";
    static EventChannel channel;
    private Activity activity;

    private ActToFlutterPlugin(Activity activity) {
        this.activity = activity;
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        channel = new EventChannel(registrar.messenger(), CHANNEL);
        ActToFlutterPlugin instance = new ActToFlutterPlugin(registrar.activity());
        channel.setStreamHandler(instance);
    }

    @Override
    public void onListen(Object o, EventChannel.EventSink eventSink) {
        eventSink.success("从原生传递flutter");
    }

    @Override
    public void onCancel(Object o) {

    }
}
