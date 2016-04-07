package com.example.administrator.intenttest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button_play;
    private EditText edInputNum;
    private Button button_Login_01;
    private Button button_Login_02;
    private EditText editText_UserName;
    private EditText editText_Psd;
    public static final int REQUSET = 1;
    private TextView tv_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitView();
    }


    private void InitView() {
        button_play = (Button) findViewById(R.id.play);
        button_play.setOnClickListener(this);

        edInputNum = (EditText) findViewById(R.id.etInputNum);

        button_Login_01 = (Button) findViewById(R.id.Login_01);
        button_Login_01.setOnClickListener(this);

        button_Login_02 = (Button) findViewById(R.id.Login_02);
        button_Login_02.setOnClickListener(this);

        editText_UserName = (EditText) findViewById(R.id.et_uerName);

        editText_Psd = (EditText) findViewById(R.id.et_psd);
        tv_info= (TextView) findViewById(R.id.tv_info);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.play:
                paly_Phone();
                break;
            case R.id.Login_01:
                Login_01();
                break;
            case R.id.Login_02:
                Login_02();
                break;
        }
    }

    private void paly_Phone() {
        Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + edInputNum.getText().toString()));
        startActivity(dialIntent);
    }

    private void Login_01() {
        Bundle bundle = new Bundle();
        bundle.putString("name", editText_UserName.getText().toString());
        bundle.putString("psd", editText_Psd.getText().toString());

        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.setClass(MainActivity.this, SubActivity1.class);
        startActivity(intent);
    }

    private void Login_02() {
        Intent intent = new Intent(MainActivity.this,SubActivity02.class);
        startActivityForResult(intent,REQUSET);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
      switch (requestCode){
          case REQUSET:
              if(resultCode==100){
                  tv_info.setText(data.getStringExtra("position"));
              }
              break;

      }
    }
}
