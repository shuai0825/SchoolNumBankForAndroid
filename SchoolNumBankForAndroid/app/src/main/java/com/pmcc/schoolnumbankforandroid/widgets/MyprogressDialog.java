package com.pmcc.schoolnumbankforandroid.widgets;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.pmcc.schoolnumbankforandroid.R;

/**
 * Created by ${zhangshuai} on 2018/9/10.
 * 2751157603@qq.com
 */
public class MyprogressDialog extends Dialog {
    private final ImageView myDialogIv;
    private TextView myDialogTv;

    public MyprogressDialog(@NonNull Context context) {
        super(context, R.style.MyProgressDialog);
        setContentView(R.layout.dialog_my_progress);
        myDialogIv = findViewById(R.id.my_dialog_iv);
        myDialogTv = findViewById(R.id.my_dialog_tv);

    }

    public void showMsg(String msg) {
        show();
        if (msg == null) {
            myDialogTv.setText("加载中...");
        } else {
            myDialogTv.setText(msg);
        }
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.dialog_progress_anim);
            myDialogIv.startAnimation(animation);
        } else {
            myDialogIv.clearAnimation();
        }
    }
}
