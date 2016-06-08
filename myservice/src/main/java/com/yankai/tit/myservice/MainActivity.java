package com.yankai.tit.myservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {
    private static String TAG="MyService";
    //private static final String TAG = "MainActivity";
    private Button btn_start;
    private Button btn_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitView();
    }

    private void InitView() {
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_stop= (Button) findViewById(R.id.btn_stop);

       final  Intent ServiceIntent=new Intent();
        /*
        启动服务
         */
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServiceIntent.setClass(MainActivity.this,MyService.class);
                startService(ServiceIntent);
                Log.i(TAG,"StartService");
                Log.d(TAG, "onClick:");
            }
        });

//增加service的停止
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"StopService");
                stopService(ServiceIntent);
            }
        });

    }
}
