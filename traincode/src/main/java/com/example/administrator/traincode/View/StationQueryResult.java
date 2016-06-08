package com.example.administrator.traincode.View;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.administrator.traincode.Model.TrainQueryCityInfo;
import com.example.administrator.traincode.NetWork.TrainCodeNet;
import com.example.administrator.traincode.R;
import com.example.administrator.traincode.Untils.PaserJsonTools;
import com.example.administrator.traincode.Untils.StationAdapter;
import com.thinkland.sdk.android.Parameters;

import java.util.List;

/**
 * Created by dell on 2015/11/11.
 */
public class StationQueryResult extends AppCompatActivity {
    private ListView listView;
    private List mList;
    private static String TAG="StationQueryResult";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.station_query_result);
        Inint();
    }
    private void Inint(){
        Intent intent=getIntent();
        String result=intent.getStringExtra("Result");
        mList= PaserJsonTools.paser_Station_Result_json(result);
        Log.d(TAG, String.valueOf(mList.size()));
        Log.d(TAG, result);
        this.listView= (ListView) this.findViewById(R.id.lv_station_result);
        StationAdapter stationAdapter=new StationAdapter(this,mList);
        listView.setAdapter(stationAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TrainQueryCityInfo trainQueryCityInfo= (TrainQueryCityInfo) mList.get(position);
                String trainCode=trainQueryCityInfo.getTrainOpp();
                Parameters parameters=new Parameters();
                parameters.add("name",trainCode);
                TrainCodeNet.TrainCodeQuery_net(parameters);
            }
        });
    }
}
