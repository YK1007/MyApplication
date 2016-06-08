package com.example.administrator.traincode.Untils;



import com.example.administrator.traincode.Model.Station_list;
import com.example.administrator.traincode.Model.TrainQueryCityInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2015/11/12.
 */
public class PaserJsonTools {
    /**
     * @param string 从服务端获取的Json字符串
     * @return 返回一个装有车次消息的List；
     */

    //http://apis.juhe.cn/train/s?name=g4&key=4e6457b4dcf02b94efbd0998dd39f5c0

    public static List<TrainQueryCityInfo> paser_Station_Result_json(String string) {
        List<TrainQueryCityInfo> list = new ArrayList<>();
        try {
            JSONObject result = new JSONObject(string).getJSONObject("result");
            JSONArray jsonArray = result.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectIndex = (JSONObject) jsonArray.get(i);
                TrainQueryCityInfo trainQueryCityInfo = new TrainQueryCityInfo();
                trainQueryCityInfo.setTrainOpp(jsonObjectIndex.getString("trainOpp"));
                trainQueryCityInfo.setTrain_typename(jsonObjectIndex.getString("train_typename"));
                trainQueryCityInfo.setStart_staion(jsonObjectIndex.getString("start_staion"));
                trainQueryCityInfo.setEnd_station(jsonObjectIndex.getString("end_station"));
                trainQueryCityInfo.setLeave_time(jsonObjectIndex.getString("leave_time"));
                trainQueryCityInfo.setArrived_time(jsonObjectIndex.getString("arrived_time"));
                trainQueryCityInfo.setMileage(jsonObjectIndex.getString("mileage"));
                list.add(trainQueryCityInfo);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     *
     * @param string 车次查询结果里的”train——info“
     * @return 返回车次的整体消息（一个实体类）
     */
    public static TrainQueryCityInfo paser_code_query_trainInfo(String string) {
        TrainQueryCityInfo trainQueryCityInfo = new TrainQueryCityInfo();
        try {
            JSONObject result = new JSONObject(string).getJSONObject("result");
            JSONArray json = result.getJSONArray("train_info");
            for (int i = 0; i < json.length(); i++) {
                JSONObject jsonObjectIndex = (JSONObject) json.get(i);
                trainQueryCityInfo.setTrainOpp(jsonObjectIndex.getString("name"));
                trainQueryCityInfo.setStart_staion(jsonObjectIndex.getString("start"));
                trainQueryCityInfo.setEnd_station(jsonObjectIndex.getString("end"));
                trainQueryCityInfo.setLeave_time(jsonObjectIndex.getString("starttime"));
                trainQueryCityInfo.setArrived_time(jsonObjectIndex.getString("endtime"));
                trainQueryCityInfo.setMileage(jsonObjectIndex.getString("mileage"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return trainQueryCityInfo;
    }
    public static List<Station_list> paser_code_query_staion_list(String string){
        List<Station_list> lists=new ArrayList<Station_list>();
        JSONObject result = null;
        try {
            result = new JSONObject(string).getJSONObject("result");
            JSONArray jsonArray = result.getJSONArray("station_list");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObjectIndex = (JSONObject) jsonArray.get(i);
                Station_list station_list=new Station_list();
                station_list.setTrain_id(jsonObjectIndex.getInt("train_id"));
                station_list.setStation_name(jsonObjectIndex.getString("station_name"));
                station_list.setArrived_time(jsonObjectIndex.getString("arrived_time"));
                station_list.setleave_time(jsonObjectIndex.getString("leave_time"));
                station_list.setMileage(jsonObjectIndex.getString("mileage"));
                station_list.setFsoftSeat(jsonObjectIndex.getString("fsoftSeat"));
                station_list.setSsoftSeat(jsonObjectIndex.getString("ssoftSeat"));
                station_list.setHardSead(jsonObjectIndex.getString("hardSead"));
                station_list.setSoftSeat(jsonObjectIndex.getString("softSeat"));
                station_list.setHardSleep(jsonObjectIndex.getString("hardSleep"));
                station_list.setSoftSleep(jsonObjectIndex.getString("softSleep"));
                station_list.setWuzuo(jsonObjectIndex.getString("wuzuo"));
                station_list.setSwz(jsonObjectIndex.getString("swz"));
                station_list.setTdz(jsonObjectIndex.getString("tdz"));
                station_list.setGjrw(jsonObjectIndex.getString("gjrw"));
                station_list.setStay(jsonObjectIndex.getString("stay"));
                lists.add(station_list);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lists;
    }
}
