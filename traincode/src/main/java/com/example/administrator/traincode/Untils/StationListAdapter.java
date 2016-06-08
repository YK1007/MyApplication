package com.example.administrator.traincode.Untils;

import android.content.Context;
import android.util.Log;
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
public class StationListAdapter extends BaseAdapter {
    private static String TAG = "StationListAdapter";
    private List<Station_list> mList;
    private LayoutInflater mInflater;
    private int Count = 0;
    private int num = 0;

    public StationListAdapter(Context context, List<Station_list> lists) {
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


    //根据类型来选择加载那种视图
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    //告诉HoldView 来缓冲几种布局；
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ///-------------------------逗逼式--------------------------//
//        if (position == 0) {
//            View view = mInflater.inflate(R.layout.first_station_item, null);
//            TextView Station_name = (TextView) view.findViewById(R.id.Station_name);
//            Station_name.setText(mList.get(0).getStation_name());
//            TextView leave_time = (TextView) view.findViewById(R.id.leave_time);
//            leave_time.setText(mList.get(0).getLeave_time());
//            return view;
//        } else {
//            View view = mInflater.inflate(R.layout.code_result_item, null);
//            TextView Staion_ID = (TextView) view.findViewById(R.id.Station_id);
//            TextView Staion_name = (TextView) view.findViewById(R.id.Station_name);
//            TextView Arrived_time = (TextView) view.findViewById(R.id.arrived_time);
//            TextView Leave_time = (TextView) view.findViewById(R.id.leave_time);
//            TextView Mileage = (TextView) view.findViewById(R.id.mileage);
//            TextView hardSead = (TextView) view.findViewById(R.id.hardSead);
//            TextView hardSleep = (TextView) view.findViewById(R.id.hardSleep);
//            TextView softSleep = (TextView) view.findViewById(R.id.softSleep);
//            TextView wuzuo = (TextView) view.findViewById(R.id.wuzuo);
//            TextView fsoftSeat = (TextView) view.findViewById(R.id.fsoftSeat);
//            TextView ssoftSeat = (TextView) view.findViewById(R.id.ssoftSeat);
//            TextView swz = (TextView) view.findViewById(R.id.swz);
//            TextView tdz = (TextView) view.findViewById(R.id.tdz);
//            TextView gjrw = (TextView) view.findViewById(R.id.gjrw);
//            Staion_ID.setText(String.valueOf(mList.get(position).getTrain_id()));
//            Staion_name.setText(mList.get(position).getStation_name());
//            Arrived_time.setText(mList.get(position).getArrived_time());
//            Leave_time.setText(mList.get(position).getLeave_time());
//            Mileage.setText(mList.get(position).getMileage());
//            hardSead.setText(mList.get(position).getHardSead());
//            hardSleep.setText(mList.get(position).getHardSleep());
//            softSleep.setText(mList.get(position).getSoftSleep());
//            wuzuo.setText(mList.get(position).getWuzuo());
//            fsoftSeat.setText(mList.get(position).getFsoftSeat());
//            ssoftSeat.setText(mList.get(position).getSsoftSeat());
//            swz.setText(mList.get(position).getSwz());
//            tdz.setText(mList.get(position).getTdz());
//            gjrw.setText(mList.get(position).getGjrw());
//            return view;
//        }}


        //-------------------文艺式--------------------------//
        ViewHold holder;

        Log.d(TAG, "position:" + position + "   convertView:" + convertView);
        View viewItemFirst;
        View viewContent;
        if (getItemViewType(position) == 0) {
            ViewHoldFirst viewHoldFirst = null;
            if (convertView == null) {
                viewHoldFirst = new ViewHoldFirst();

                viewItemFirst = mInflater.inflate(R.layout.first_station_item, null, false);

                viewHoldFirst.Staion_name = (TextView) viewItemFirst.findViewById(R.id.Station_name);
                viewHoldFirst.Leave_time = (TextView) viewItemFirst.findViewById(R.id.leave_time);
                viewItemFirst.setTag(viewHoldFirst);
                convertView = viewItemFirst;

            } else {
                viewHoldFirst = (ViewHoldFirst) convertView.getTag();
            }
            viewHoldFirst.Staion_name.setText(mList.get(position).getStation_name());
            viewHoldFirst.Leave_time.setText(mList.get(position).getLeave_time());

        } else {

            if (convertView == null) {

                holder = new ViewHold();

                viewContent = mInflater.inflate(R.layout.code_result_item, null, false);

                holder.Staion_ID = (TextView) viewContent.findViewById(R.id.Station_id);
                holder.Staion_name = (TextView) viewContent.findViewById(R.id.Station_name);
                holder.Arrived_time = (TextView) viewContent.findViewById(R.id.arrived_time);
                holder.Leave_time = (TextView) viewContent.findViewById(R.id.leave_time);
                holder.Mileage = (TextView) viewContent.findViewById(R.id.mileage);
                holder.hardSead = (TextView) viewContent.findViewById(R.id.hardSead);
                holder.hardSleep = (TextView) viewContent.findViewById(R.id.hardSleep);
                holder.softSleep = (TextView) viewContent.findViewById(R.id.softSleep);
                holder.wuzuo = (TextView) viewContent.findViewById(R.id.wuzuo);
                viewContent.setTag(holder);
                convertView = viewContent;
                Count++;
                Log.d(TAG, "count=" + Count);
            } else {
                //通过tag找到缓存的布局
                num++;
                Log.d(TAG, "num=" + num);

                holder = (ViewHold) convertView.getTag();
                Log.d(TAG, "holder=" + holder);


            }
            holder.Staion_ID.setText(String.valueOf(mList.get(position).getTrain_id()));
            holder.Staion_name.setText(mList.get(position).getStation_name());
            holder.Arrived_time.setText(mList.get(position).getArrived_time());
            holder.Leave_time.setText(mList.get(position).getLeave_time());
            holder.Mileage.setText(mList.get(position).getMileage());
            holder.hardSead.setText(mList.get(position).getHardSead());
            holder.hardSleep.setText(mList.get(position).getHardSleep());
            holder.softSleep.setText(mList.get(position).getSoftSleep());
            holder.wuzuo.setText(mList.get(position).getWuzuo());
        }
        return convertView;
    }

    public final class ViewHold {
        public TextView Staion_ID;
        public TextView Staion_name;
        public TextView Arrived_time;
        public TextView Leave_time;
        public TextView Mileage;
        public TextView hardSead;
        public TextView hardSleep;
        public TextView softSleep;
        public TextView wuzuo;
    }

    public final class ViewHoldFirst {
        public TextView Staion_name;
        public TextView Leave_time;
    }
}
