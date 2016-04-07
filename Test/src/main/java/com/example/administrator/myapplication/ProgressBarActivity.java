package com.example.administrator.myapplication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/3/31.
 */
public class ProgressBarActivity extends AppCompatActivity implements View.OnClickListener,SeekBar.OnSeekBarChangeListener {
    private Button button_add;
    private Button button_reduce;
    private Button btn_VisiPb;
    private Button btn_ProgressDialog;
    private ProgressBar progressBar_small;
//    private ProgressBar progressBar_large;
//    private ProgressBar progressBar_inverse;
    private ProgressBar progressBar_horizontal;
    private SeekBar seekBar;
    private TextView tv_seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_progressbar);
        InitView();
    }
    private void InitView(){
        button_add= (Button) findViewById(R.id.add);
        button_add.setOnClickListener(this);

        button_reduce= (Button) findViewById(R.id.reduce);
        button_reduce.setOnClickListener(this);

        btn_ProgressDialog= (Button) findViewById(R.id.btn_ProgressDialog);
        btn_ProgressDialog.setOnClickListener(this);

        btn_VisiPb= (Button) findViewById(R.id.btn_VisiPb);
        btn_VisiPb.setOnClickListener(this);

        progressBar_small= (ProgressBar) findViewById(R.id.progressBar_small);
//        progressBar_large= (ProgressBar) findViewById(R.id.progressBar_large);
//        progressBar_inverse= (ProgressBar) findViewById(R.id.progressBar_inverse);
        progressBar_horizontal= (ProgressBar) findViewById(R.id.progressBar_horizontal);

        seekBar= (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);
        tv_seekBar= (TextView) findViewById(R.id.tv_seekBar);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_VisiPb:
                Visible();
                break;
            case R.id.btn_ProgressDialog:
                CreatProgressDialog();
                break;
            case R.id.reduce:
                reduce();
                break;
            case R.id.add:
                add();
                break;
        }
    }
    private  void Visible(){
        if(progressBar_small.getVisibility()==View.VISIBLE){
            progressBar_small.setVisibility(View.GONE);
        }else {
            progressBar_small.setVisibility(View.VISIBLE);
        }
    }
    private void CreatProgressDialog(){
        ProgressDialog  progress_dialog=new ProgressDialog(ProgressBarActivity.this);
        progress_dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress_dialog.setTitle("进度条对话框");
        progress_dialog.setMessage("这里是显示的内容");
        progress_dialog.setCancelable(true);
        progress_dialog.setProgress(50);
        progress_dialog.setSecondaryProgress(70);
        progress_dialog.setMax(100);
        progress_dialog.show();
    }

    private void add(){
        if(progressBar_horizontal.getProgress()<50){
            progressBar_horizontal.setProgress((int) (progressBar_horizontal.getProgress()*1.2));
        }
        if(progressBar_horizontal.getSecondaryProgress()<100){
            progressBar_horizontal.setSecondaryProgress((int) (progressBar_horizontal.getSecondaryProgress() * 1.2));
        }
    }
    private void reduce(){
        if(progressBar_horizontal.getProgress()>10){
            progressBar_horizontal.incrementProgressBy(-10);

        }if(progressBar_horizontal.getSecondaryProgress()>20){
            progressBar_horizontal.incrementSecondaryProgressBy(-10);
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        tv_seekBar.setText("当前位置："+progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        tv_seekBar.setText("拖动滑块设置");
    }
}
