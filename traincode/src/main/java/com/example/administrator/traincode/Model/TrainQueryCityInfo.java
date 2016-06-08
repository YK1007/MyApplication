package com.example.administrator.traincode.Model;

import java.io.Serializable;

/**
 * Created by dell on 2015/11/10.
 */
public class TrainQueryCityInfo implements Serializable {
    private String trainOpp;
    private String train_typename;
    private String start_staion;
    private String end_station;
    private String leave_time;
    private String arrived_time;
    private String mileage;

    public String getTrainOpp() {
        return trainOpp;
    }

    public void setTrainOpp(String trainOpp) {
        this.trainOpp = trainOpp;
    }

    public String getTrain_typename() {
        return train_typename;
    }

    public void setTrain_typename(String train_typename) {
        this.train_typename = train_typename;
    }

    public String getStart_staion() {
        return start_staion;
    }

    public void setStart_staion(String start_staion) {
        this.start_staion = start_staion;
    }

    public String getEnd_station() {
        return end_station;
    }

    public void setEnd_station(String end_station) {
        this.end_station = end_station;
    }

    public String getLeave_time() {
        return leave_time;
    }

    public void setLeave_time(String leave_time) {
        this.leave_time = leave_time;
    }

    public String getArrived_time() {
        return arrived_time;
    }

    public void setArrived_time(String arrived_time) {
        this.arrived_time = arrived_time;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }
}
