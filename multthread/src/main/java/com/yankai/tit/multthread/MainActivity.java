package com.yankai.tit.multthread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button Button[] = new Button[4];
    private boolean stop = true;
    private static String TAG = "MainActivity";
    private static EditText editText;
    private EditText editText2;
    private static ProgressBar progressBar;
    private static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 10) {
                progressBar.setProgress(msg.arg1);
                //editText.setText(msg.arg1+"");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InintView();
    }

    private void InintView() {

        Button[0] = (android.widget.Button) findViewById(R.id.button);
        Button[0].setOnClickListener(this);

        Button[1] = (android.widget.Button) findViewById(R.id.button2);
        Button[1].setOnClickListener(this);

        Button[2] = (android.widget.Button) findViewById(R.id.button3);
        Button[2].setOnClickListener(this);

        Button[3] = (android.widget.Button) findViewById(R.id.button4);
        Button[3].setOnClickListener(this);

        editText = (EditText) findViewById(R.id.editText);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                singleThread();
                break;
            case R.id.button2:
                multiThread();
                break;
            case R.id.button3:
                stop();
                break;
            case R.id.button4:
                download();
                break;
        }
    }

    private int singleThread() {
        int sum = 0;
        for (int i = 0; i < 1000000; i++) {
            sum = sum + i;
            //  Log.d(TAG, "单线程" + String.valueOf(sum));
        }
        Log.d(TAG, "单线程" + String.valueOf(sum));
        return sum;
    }

    private void multiThread() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (stop) {
                    int sum = 0;
                    for (int i = 0; i < 1000000; i++) {
                        sum += i;
                        // Log.d(TAG, "多线程" + String.valueOf(sum));
                    }
                    Log.d(TAG, "多线程" + String.valueOf(sum));
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private void stop() {
        if (stop != true) {
            stop = true;
        } else {
            stop = false;
        }
    }

    private void download() {
        String step = editText.getText().toString();
        int step_num = step.indexOf(step);
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int nProgress = 0;
                while (nProgress < 100) {
                    try {
                        Thread.sleep(1000);
                        nProgress += 5;
                        Message message = Message.obtain();
                        message.arg1 = nProgress;
                        message.what = 10;
                        handler.sendMessage(message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        thread.start();
    }

}
