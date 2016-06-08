package com.example.administrator.traincode.NetWork;

import android.content.Intent;
import android.util.Log;


import com.example.administrator.traincode.View.Code_Query_result;
import com.example.administrator.traincode.View.MainMenuActivity;
import com.thinkland.sdk.android.DataCallBack;
import com.thinkland.sdk.android.JuheData;
import com.thinkland.sdk.android.Parameters;

/**
 * Created by dell on 2015/11/16.
 */
public class TrainCodeNet {
    private static String TAG="TrainCodeNet";
    private static String code_result = null;
    public static String TrainCodeQuery_net(Parameters parameters) {
        JuheData.executeWithAPI(MainMenuActivity.mContext, 22, "http://apis.juhe.cn/train/s",
                JuheData.GET, parameters, new DataCallBack() {
                    @Override
                    public void onSuccess(int i, String s) {
                        code_result = s;
                        Log.d(TAG, s);
                    }

                    @Override
                    public void onFinish() {
                        Intent intent = new Intent();
                        intent.putExtra("Result", code_result);
                        intent.setClass(MainMenuActivity.instance, Code_Query_result.class);
                        MainMenuActivity.instance.startActivity(intent);
                        Log.d(TAG, "onFinish");
                    }

                    @Override
                    public void onFailure(int i, String s, Throwable throwable) {
                        Log.d(TAG, "onFailure");
                    }
                });
        return code_result;
    }
}
