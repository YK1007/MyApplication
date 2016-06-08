package com.example.administrator.traincode.Controller;


import android.content.Intent;
import android.os.Handler;
import android.os.Message;


import com.example.administrator.traincode.MainActivity;
import com.example.administrator.traincode.View.MainMenuActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by dell on 2015/11/9.
 */
public class Controller {
//    public static void handler(int EventID)
//    {
//        switch (EventID)
//        {
//            case Event.SHOW_MAINMENU:
//                final Intent intent = new Intent(MainActivity.instance,
//                        MainMenuActivity.class);
//                Timer timer = new Timer();
//                TimerTask task = new TimerTask() {
//                    @Override
//                    public void run() {
//                        MainActivity.instance.startActivity(intent); // Ö´ÐÐ
//                        MainActivity.instance.finish();
//                    }
//                };
//                timer.schedule(task, 3000);
//                break;
//        }
//    }



    public static Handler handler=new Handler(){

        @Override
           public void handleMessage(Message msg) {
            int EventID=msg.what;
            switch (EventID){
                case Event.SHOW_MAINMENU:
                  final   Intent intent = new Intent(MainActivity.instance,
                            MainMenuActivity.class);
                    Timer timer = new Timer();
                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {

                            MainActivity.instance.startActivity(intent);
                            MainActivity.instance.finish();
                        }
                    };
                    timer.schedule(task, 3000); // 10Ãëºó
                    break;
            }
        }
    };
}
