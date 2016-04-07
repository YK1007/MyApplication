package com.example.administrator.myapplication;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/3/10.
 */
public class MyActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private RadioButton radioButton[] = new RadioButton[4];
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.layout01);
        this.radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioButton[0] = (RadioButton) findViewById(R.id.radio);
        radioButton[1] = (RadioButton) findViewById(R.id.radio1);
        radioButton[2] = (RadioButton) findViewById(R.id.radio2);
        radioButton[3] = (RadioButton) findViewById(R.id.radio3);
        for (int i = 0; i < radioButton.length; i++) {
            radioButton[i].setOnCheckedChangeListener(this);
            radioButton[i].setChecked(false);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked == true) {
            Toast.makeText(MyActivity.this, buttonView.getText(), Toast.LENGTH_LONG).show();
        }
    }
}
