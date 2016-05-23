package com.yankai.tit.asynctaskdowm;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private Button button;
    private TextView textView;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitView();
    }

    private void InitView() {

        progressDialog = new ProgressDialog(this);
        progressDialog.setMax(100);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setCancelable(false);

        textView= (TextView) findViewById(R.id.textView);

        button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAsyncTask myAsyncTask=new MyAsyncTask();
                myAsyncTask.execute("https://www.baidu.com/");
            }
        });
    }
    private class MyAsyncTask extends AsyncTask<String,Integer,String>{

        @Override
        protected String doInBackground(String... params) {
            String downContent=null;
            try {
                URL url=new URL(params[0]);
                HttpURLConnection conn= (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Accept-Encoding","identity");

                int total=conn.getContentLength();
                Log.d(TAG, "doInBackground: "+total);
                InputStream is=conn.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
                byte[] buf=new byte[1024];
                int count=0;
                int length=-1;
                while ((length=is.read())!=-1){
                    byteArrayOutputStream.write(buf,0,length);
                    count=count+length;
                    Log.d(TAG, "doInBackground: "+count);
                    Log.d(TAG, "doInBackground: "+(count/(float)total)*100);
                    publishProgress((int)((count/(float)total)*100));
                    Thread.sleep(300);
                }
                downContent= byteArrayOutputStream.toString();
                conn.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return downContent;
        }

        @Override
        protected void onPreExecute() {
            progressDialog.show();
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String string) {
            super.onPostExecute(string);
            progressDialog.dismiss();
            textView.setText(string);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressDialog.setProgress(values[0]);
        }
    }
}
