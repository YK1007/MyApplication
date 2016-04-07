package com.example.administrator.myapplication;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    private String y="dfdslj";
    private static  String  TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"YANAKI");
        try {
            FileInputStream fileInputStream = new FileInputStream("yankai.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
