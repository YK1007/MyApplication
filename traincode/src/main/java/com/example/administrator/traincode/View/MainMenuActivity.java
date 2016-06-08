package com.example.administrator.traincode.View;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.traincode.NetWork.TrainCiteyQuery;
import com.example.administrator.traincode.NetWork.TrainCodeNet;
import com.example.administrator.traincode.R;
import com.thinkland.sdk.android.Parameters;


/**
 * Created by dell on 2015/11/9.
 */
public class MainMenuActivity extends Activity {
    public static String TAG = "MainMenuActivity";
    public static MainMenuActivity instance = null;
    private EditText StartCity;
    private EditText ArriveCity;
    private EditText TrainCode;
    private Button Button_Query, Code_query;
    public static Context mContext;
    private String code_result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        mContext = this;
        instance = this;
        InitView();
        Mylistener();
    }

    private void InitView() {
        this.StartCity = (EditText) this.findViewById(R.id.Start_City);
        this.ArriveCity = (EditText) this.findViewById(R.id.Arrive_City);
        this.Button_Query = (Button) this.findViewById(R.id.query);
        this.TrainCode = (EditText) this.findViewById(R.id.Code_Edit);
        this.Code_query = (Button) this.findViewById(R.id.Code_query);
    }

    private void Mylistener() {
        Button_Query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String Start = StartCity.getText().toString();
                final String Arrive = ArriveCity.getText().toString();
                Parameters parameters = new Parameters();
                parameters.add("start", Start);
                parameters.add("end", Arrive);
                TrainCiteyQuery.TrainCiteyQuery_net(parameters);
//                JuheData.executeWithAPI(mContext, 22, "http://apis.juhe.cn/train/s2s",
//                        JuheData.GET, parameters, new DataCallBack() {
//                            @Override
//                            public void onSuccess(int i, String s) {
//                                result = s;
//                                Log.d(TAG, result);
//                            }
//
//                            @Override
//                            public void onFinish() {
//                                Intent intent = new Intent();
//                                intent.putExtra("Result", result);
//                                intent.setClass(MainMenuActivity.this, StationQueryResult.class);
//                                MainMenuActivity.this.startActivity(intent);
//                                Log.d(TAG, "onFinish");
//                            }
//
//                            @Override
//                            public void onFailure(int i, String s, Throwable throwable) {
//                                Log.d(TAG, "onFailure");
//                            }
//                        });
            }
        });
        Code_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String trainCode = TrainCode.getText().toString();
                Parameters parameters = new Parameters();
                parameters.add("name", trainCode);
                TrainCodeNet.TrainCodeQuery_net(parameters);
//                JuheData.executeWithAPI(mContext, 22, "http://apis.juhe.cn/train/s",
//                        JuheData.GET, parameters, new DataCallBack() {
//                            @Override
//                            public void onSuccess(int i, String s) {
//                                code_result = s;
//                                Log.d(TAG, s);
//                            }
//
//                            @Override
//                            public void onFinish() {
//                                Intent intent=new Intent();
//                                intent.putExtra("Result", code_result);
//                                intent.setClass(MainMenuActivity.this, Code_Query_result.class);
//                                MainMenuActivity.this.startActivity(intent);
//                                Log.d(TAG, "onFinish");
//                            }
//
//                            @Override
//                            public void onFailure(int i, String s, Throwable throwable) {
//                                Log.d(TAG, "onFailure");
//                            }
//                        });
            }
        });
    }
}
