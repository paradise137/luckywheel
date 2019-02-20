package com.example.liangxintong.luckywheel;

public class RecyclerViewData {

    private String user;

    private String present;

    private String time;

    public RecyclerViewData (String user , String present , String time){

        this.present = present;
        this.time = time;
        this.user = user;

    }

    public String getUser(){
        return user;
    }

    public String getPresent(){
        return present;
    }

    public String getTime(){
        return time;
    }
}
