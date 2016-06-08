package com.example.administrator.traincode.Model;

import java.io.Serializable;


/**
 * Created by dell on 2015/11/10.
 */
public class Station_list implements Serializable {
    private int train_id;    //int	站点序号
    private String station_name;    //string	站点名称
    private String arrived_time;    //string	到达时间
    private String leave_time;    //string	发车时间
    private String stay;    //string	停留
    private String mileage;    //string	里程
    private String ssoftSeat;//string	二等座
    private String fsoftSeat;    //string	一等座
    private String hardSead;    //string	硬座
    private String softSeat;    //string	软座
    private String hardSleep;    //string	硬卧
    private String softSleep;    //string	软卧
    private String wuzuo;    //string	无座
    private String swz;    //string	商务座
    private String tdz;    //string	特等座
    private String gjrw;    //string高级软卧

    public int getTrain_id() {
        return train_id;
    }

    public void setTrain_id(int train_id) {
        this.train_id = train_id;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public String getArrived_time() {
        return arrived_time;
    }

    public void setArrived_time(String arrived_time) {
        this.arrived_time = arrived_time;
    }

    public String getLeave_time() {
        return leave_time;
    }

    public void setleave_time(String eave_time) {
        this.leave_time = eave_time;
    }

    public String getStay() {
        return stay;
    }

    public void setStay(String stay) {
        this.stay = stay;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getSsoftSeat() {
        return ssoftSeat;
    }

    public void setSsoftSeat(String ssoftSeat) {
        this.ssoftSeat = ssoftSeat;
    }

    public String getFsoftSeat() {
        return fsoftSeat;
    }

    public void setFsoftSeat(String fsoftSeat) {
        this.fsoftSeat = fsoftSeat;
    }

    public String getHardSead() {
        return hardSead;
    }

    public void setHardSead(String hardSead) {
        this.hardSead = hardSead;
    }

    public String getSoftSeat() {
        return softSeat;
    }

    public void setSoftSeat(String softSeat) {
        this.softSeat = softSeat;
    }

    public String getHardSleep() {
        return hardSleep;
    }

    public void setHardSleep(String hardSleep) {
        this.hardSleep = hardSleep;
    }

    public String getSoftSleep() {
        return softSleep;
    }

    public void setSoftSleep(String softSleep) {
        this.softSleep = softSleep;
    }

    public String getWuzuo() {
        return wuzuo;
    }

    public void setWuzuo(String wuzuo) {
        this.wuzuo = wuzuo;
    }

    public String getSwz() {
        return swz;
    }

    public void setSwz(String swz) {
        this.swz = swz;
    }

    public String getTdz() {
        return tdz;
    }

    public void setTdz(String tdz) {
        this.tdz = tdz;
    }

    public String getGjrw() {
        return gjrw;
    }

    public void setGjrw(String gjrw) {
        this.gjrw = gjrw;
    }
}
