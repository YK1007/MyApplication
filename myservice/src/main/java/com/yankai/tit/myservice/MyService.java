package com.yankai.tit.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static String TAG="MyService";
    private boolean  flag=true;
    public MyService() {
    }
    private  void setFlag(){
        flag=false;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"MyService:onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onCreate() {
        Log.i(TAG,"MyService:onCreate");
        Log.i(TAG,flag+"");
        super.onCreate();
        NotifThread notifThread=new NotifThread();
        notifThread.start();
    }
    @Override
    public void onDestroy() {
        setFlag();
       // Log.i(TAG,flag+"");
        Log.i(TAG,"MyService:onDestroy");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    class NotifThread extends Thread {
        @Override
        public void run() {
            super.run();
            while (flag){
                try {
                    sleep(1000);
                    Log.i(TAG,"获取更新");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
