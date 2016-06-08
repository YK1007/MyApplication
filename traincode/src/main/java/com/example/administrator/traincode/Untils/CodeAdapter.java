package com.example.administrator.traincode.Untils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.administrator.traincode.Model.Station_list;
import com.example.administrator.traincode.R;

import java.util.List;

/**
 * Created by dell on 2015/11/16.
 */

public class CodeAdapter extends BaseAdapter {
    private List<Station_list> mList;
    private LayoutInflater mInflater;

    public CodeAdapter(Context context, List<Station_list> lists) {
        this.mList = lists;
        this.mInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Code_ViewHolder holder;
        if (convertView == null) {
            holder = new Code_ViewHolder();
            convertView = mInflater.inflate(R.layout.simple_item, null);
            holder.Staion_ID = (TextView) convertView.findViewById(R.id.Station_id);
            holder.Staion_name = (TextView) convertView.findViewById(R.id.Station_name);
            holder.Arrived_time = (TextView) convertView.findViewById(R.id.arrived_time);
            holder.Leave_time = (TextView) convertView.findViewById(R.id.leave_time);
            holder.Stay_time = (TextView) convertView.findViewById(R.id.Stay_time);
            holder.Mileage = (TextView) convertView.findViewById(R.id.mileage);
            convertView.setTag(holder);
        } else {
            holder = (Code_ViewHolder) convertView.getTag();
        }
        holder.Staion_ID.setText(String.valueOf(mList.get(position).getTrain_id()));
        holder.Staion_name.setText(mList.get(position).getStation_name());
        holder.Arrived_time.setText(mList.get(position).getArrived_time());
        holder.Leave_time.setText(mList.get(position).getLeave_time());
        holder.Stay_time.setText(mList.get(position).getStay());
        holder.Mileage.setText(mList.get(position).getMileage());
        return convertView;
    }
    public final class Code_ViewHolder {
        public TextView Staion_ID;
        public TextView Staion_name;
        public TextView Arrived_time;
        public TextView Leave_time;
        public TextView Stay_time;
        public TextView Mileage;
    }
}
