package com.yankai.tit.multthread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/5/12.
 */
public class MainTestActivity extends AppCompatActivity  implements Runnable{
    private static String TAG = "MainActivity";
    private static TextView textView;
   // private int sum=0;
    private static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==1){
                textView.setText(msg.arg1+"");
            }
        }
    };

    @Override
    protected void onCreate(  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layouttest);
        textView = (TextView) findViewById(R.id.textView);
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int sum=0;
//                for (int i = 0; i < 100; i++) {
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    sum += i;
//                    Message message=Message.obtain();
//                    message.arg1=sum;
//                    message.what=1;
//                    handler.sendMessage(message);
//                }
//            }
//        });
        new Thread(this).start();
//        Thread thread=new Thread(this);
//        thread.start();
    }

    @Override
    public void run() {
        int sum=0;
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sum += i;
            Message message=Message.obtain();
            message.arg1=sum;
            message.what=1;
            handler.sendMessage(message);
        }
    }
    private class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
        }
    }
}
