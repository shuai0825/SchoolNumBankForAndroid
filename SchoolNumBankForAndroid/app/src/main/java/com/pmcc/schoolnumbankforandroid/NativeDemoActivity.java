package com.pmcc.schoolnumbankforandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.pmcc.schoolnumbankforandroid.common.utils.LogUtils;

public class NativeDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_demo);
        String data = getIntent().getStringExtra("data");
        TextView textView = findViewById(R.id.tv);
        textView.setText(data);
    }
}
