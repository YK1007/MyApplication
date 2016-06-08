package com.example.administrator.traincode.NetWork;

import android.content.Intent;
import android.util.Log;


import com.example.administrator.traincode.View.MainMenuActivity;
import com.example.administrator.traincode.View.StationQueryResult;
import com.thinkland.sdk.android.DataCallBack;
import com.thinkland.sdk.android.JuheData;
import com.thinkland.sdk.android.Parameters;


/**
 * Created by dell on 2015/11/11.
 */
public class TrainCiteyQuery {

    private static String result;
    public static String TrainCiteyQuery_net(Parameters parameters) {
        JuheData.executeWithAPI(MainMenuActivity.mContext, 22, "http://apis.juhe.cn/train/s2s",
                JuheData.GET, parameters, new DataCallBack() {
                    @Override
                    public void onSuccess(int i, String s) {
                        result = s;
                        Log.d(MainMenuActivity.TAG, result);
                    }

                    @Override
                    public void onFinish() {
                        Intent intent = new Intent();
                        intent.putExtra("Result", result);
                        intent.setClass(MainMenuActivity.instance, StationQueryResult.class);
                        MainMenuActivity.instance.startActivity(intent);
                        Log.d(MainMenuActivity.TAG, "onFinish");
                    }

                    @Override
                    public void onFailure(int i, String s, Throwable throwable) {
                        Log.d(MainMenuActivity.TAG, "onFailure");
                    }
                });
        return result;
    }


}
