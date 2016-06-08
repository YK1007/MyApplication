package com.yankai.tit.broadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static String YKACTION = "com.yankai.tit.broadcast";
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitView();
    }

    private void InitView() {
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                sendBR();
                break;
        }
    }

    private void sendBR() {
        Intent intent = new Intent();
        intent.setAction(YKACTION);
        intent.putExtra("msg", "闫凯，你好！");
        sendBroadcast(intent);
    }
}
