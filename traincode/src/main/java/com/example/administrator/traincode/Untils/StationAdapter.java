package com.example.administrator.traincode.Untils;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.administrator.traincode.Model.TrainQueryCityInfo;
import com.example.administrator.traincode.R;

import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2015/11/11.
 */
public class StationAdapter extends BaseAdapter {
    private static String TAG="StationAdapter";

    private List<TrainQueryCityInfo> mData;
    private LayoutInflater mInflater;
    private int Count = 0;
    private int num = 0;
    public StationAdapter(Context context, List<TrainQueryCityInfo> data) {
        this.mData = data;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return this.mData.size();
    }

    @Override
    public Object getItem(int position) {
        return this.mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG,"position:" + position + "   convertView:" + convertView);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = this.mInflater.inflate(R.layout.lv_station_item, null);
            viewHolder.trainOpp = (TextView) convertView.findViewById(R.id.trainOpp);
            viewHolder.train_typename = (TextView) convertView.findViewById(R.id.train_typename);
            viewHolder.start_staion = (TextView) convertView.findViewById(R.id.start_staion);
            viewHolder.end_station = (TextView) convertView.findViewById(R.id.end_station);
            viewHolder.leave_time = (TextView) convertView.findViewById(R.id.leave_time);
            viewHolder.arrived_time = (TextView) convertView.findViewById(R.id.arrived_time);
            viewHolder.mileage = (TextView) convertView.findViewById(R.id.mileage);
            convertView.setTag(viewHolder);
            Count++;
            Log.d(TAG, "count=" + Count);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            num++;
            Log.d(TAG, "num=" + num);
            Log.d(TAG, "viewHolder=" + viewHolder);
        }
        viewHolder.trainOpp.setText(mData.get(position).getTrainOpp());
        viewHolder.train_typename.setText(mData.get(position).getTrain_typename());
        viewHolder.start_staion.setText(mData.get(position).getStart_staion());
        viewHolder.end_station.setText(mData.get(position).getEnd_station());
        viewHolder.leave_time.setText(mData.get(position).getLeave_time());
        viewHolder.arrived_time.setText(mData.get(position).getArrived_time());
        viewHolder.mileage.setText(mData.get(position).getMileage());
        return convertView;
    }

    public final class ViewHolder {
        public TextView trainOpp;
        public TextView train_typename;
        public TextView start_staion;
        public TextView end_station;
        public TextView leave_time;
        public TextView arrived_time;
        public TextView mileage;

    }
}
