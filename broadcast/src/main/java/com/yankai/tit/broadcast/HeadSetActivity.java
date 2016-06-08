package com.yankai.tit.broadcast;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2016/5/19.
 */
public class HeadSetActivity extends AppCompatActivity {
    MyBR headsetPlugReceiver;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerHeadsetPlugReceiver();
    }
    private void registerHeadsetPlugReceiver(){
        headsetPlugReceiver  = new MyBR();
        IntentFilter  filter = new IntentFilter();
        filter.addAction("android.intent.action.HEADSET_PLUG");
        registerReceiver(headsetPlugReceiver, filter);
    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        unregisterReceiver();  //注销监听
    }
    private void unregisterReceiver(){
        this.unregisterReceiver(headsetPlugReceiver);
    }
}
