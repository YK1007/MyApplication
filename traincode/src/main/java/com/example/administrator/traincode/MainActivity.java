package com.example.administrator.traincode;



import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.traincode.Controller.Controller;
import com.example.administrator.traincode.Controller.Event;
import com.example.administrator.traincode.View.LogoView;
public class MainActivity extends AppCompatActivity {
    public static MainActivity instance=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance=this;
        //setContentView(R.layout.activity_main);
        LogoView logoView=new LogoView(this);
        this.setContentView(logoView);

        //---------方法一-----------//
//        Message message=Controller.handler.obtainMessage();
//        message.what= Event.SHOW_MAINMENU;
//        Controller.handler.sendMessage(message);
        //-----------方法三--------//
        Message message=new Message();
        message.what= Event.SHOW_MAINMENU;
        Controller.handler.sendMessage(message);
        //-----------------------------------//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                Intent intent=new Intent(MainActivity.this, MainMenuActivity.class);
//                MainActivity.this.startActivity(intent);
//                MainActivity.this.finish();
//
//            }
//        }).start();

            //--------------------------------//
//        new Thread(){
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                Intent intent=new Intent(MainActivity.this, MainMenuActivity.class);
//                MainActivity.this.startActivity(intent);
//                MainActivity.this.finish();
//
//            }
//        }.start();


        //-----------方法二------------------//
//        final Intent intent = new Intent(MainActivity.this,
//                MainMenuActivity.class);
//        Timer timer = new Timer();
//        TimerTask task = new TimerTask() {
//            @Override
//            public void run() {
//                MainActivity.this.startActivity(intent);
//                MainActivity.this.finish();
//            }
//        };
//        timer.schedule(task, 3000);

    }
}
