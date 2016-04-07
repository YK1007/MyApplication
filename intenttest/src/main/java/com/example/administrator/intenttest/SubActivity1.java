package com.example.administrator.intenttest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/4/7.
 */
public class SubActivity1 extends AppCompatActivity {
    private TextView textView_name;
    private TextView textView_psd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sub1);
        InitView();
        setText();
    }

    private void InitView() {
        textView_name = (TextView) findViewById(R.id.user_name);
        textView_psd = (TextView) findViewById(R.id.passWord);
    }

    private void setText() {
        Bundle bundle = this.getIntent().getExtras();
        String name = bundle.getString("name");
        String passWord = bundle.getString("psd");
        textView_name.setText(name);
        textView_psd.setText(passWord);

    }
}
