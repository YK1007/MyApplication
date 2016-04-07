package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private RadioButton RadioButton[] = new RadioButton[4];
    private Button button_query;
    private RadioGroup radioGroup;
    //    private RadioButton radioButton;
//    private RadioButton radioButton1;
//    private RadioButton radioButton2;
//    private RadioButton radioButton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitView();
        InitRadioGroup();
    }

    private void InitView() {
        textView = (TextView) this.findViewById(R.id.textView);
        button_query = (Button) this.findViewById(R.id.button_query);
        this.button_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(getResources().getString(R.string.My_name));
            }
        });
    }

    private void InitRadioGroup() {
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton[0] = (RadioButton) findViewById(R.id.radio);
        RadioButton[1] = (RadioButton) findViewById(R.id.radio1);
        RadioButton[2] = (RadioButton) findViewById(R.id.radio2);
        RadioButton[3] = (RadioButton) findViewById(R.id.radio3);
        for(int i=0;i<RadioButton.length;i++){
            RadioButton[i].setChecked(false);
        }
        //<----------------setOnCheckedChangeListener------------------------------------->
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio:
                        textView.setText(RadioButton[0].getText());
                        break;
                    case R.id.radio1:
                        textView.setText(RadioButton[1].getText());
                        break;
                    case R.id.radio2:
                        textView.setText(RadioButton[2].getText());
                        break;
                    case R.id.radio3:
                        textView.setText(RadioButton[3].getText());
                        break;
                }
            }
        });
//        radioGroup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               for(int i=0;i<radioGroup.getChildCount();i++){
//                   RadioButton radioButton= (android.widget.RadioButton) radioGroup.getChildAt(i);
//                  if(radioButton.isChecked()){
//                      textView.setText(radioButton.getText());
//                  }
//               }
//            }
//        });
    }
}
