package com.example.administrator.traincode.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.widget.ListView;


import com.example.administrator.traincode.Model.Station_list;
import com.example.administrator.traincode.R;
import com.example.administrator.traincode.Untils.PaserJsonTools;
import com.example.administrator.traincode.Untils.StationListAdapter;

import java.util.List;

/**
 * Created by dell on 2015/11/16.
 */
public class Code_Query_result extends AppCompatActivity {
    private ListView listView;
    private List<Station_list> lists;
    private static String TAG="Code_Query_result";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.code_result);
        inintView();

    }
    private void inintView()
    {
        Intent intent=getIntent();
        String result=intent.getStringExtra("Result");
        //Log.d(TAG, result);

        lists= PaserJsonTools.paser_code_query_staion_list(result);
        this.listView= (ListView) this.findViewById(R.id.code_result);
        Log.d(TAG, String.valueOf(lists.size()));
        long startTime=System.currentTimeMillis();
        StationListAdapter stationListAdapter=new StationListAdapter(this,lists);
        listView.setAdapter(stationListAdapter);
        long stopTime=System.currentTimeMillis();
        long ss=stopTime-startTime;
        Log.d(TAG, "time="+ss);
//        CodeAdapter codeAdapter=new CodeAdapter(this,lists);
//        listView.setAdapter(codeAdapter);

    }
}
