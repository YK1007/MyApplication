package com.example.administrator.intenttest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/4/7.
 */
public class SubActivity02 extends AppCompatActivity {
    private ListView listView;
    private int item_position;
    private Button  button_back;
    private final  static  int resultCode=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sub02);
        InitView();
        button_back= (Button) findViewById(R.id.back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("position", item_position);
                setResult(resultCode, intent);
            }
        });
    }
    private void InitView(){
        this.listView = (ListView) this.findViewById(R.id.listView);
        ArrayList arrayList = new ArrayList();
        int score=90;
        for (int i=0;i<5;i++) {
            HashMap map = new HashMap();
            map.put("name","yankai"+i);
            map.put("score",score+i);
            arrayList.add(map);
        }
        String[] from = {"name", "score"};
        int[] to = {R.id.textView1, R.id.textView2};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.list_item, from, to);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item_position = position;
            }
        });

    }
}
