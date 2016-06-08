package com.yankai.tit.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBR extends BroadcastReceiver {
    public MyBR() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving/
//        String atrACT=intent.getAction();
//        String headset= Intent.ACTION_HEADSET_PLUG;
//        if (atrACT.compareTo(headset)==0){
//            Toast.makeText(context, "headset  connected", Toast.LENGTH_LONG).show();
//        }
        if (intent.hasExtra("state")) {
            if (intent.getIntExtra("state", 0) == 0) {
                Toast.makeText(context, "headset not connected", Toast.LENGTH_LONG).show();
            } else if (intent.getIntExtra("state", 0) == 1) {
                Toast.makeText(context, "headset  connected", Toast.LENGTH_LONG).show();
            }
        }

        // an Intent broadcast.
        // throw new UnsupportedOperationException("Not yet implemented");
    }
}
