package com.mrsaad.hackwestern;

/**
 * Created by saad on 15-11-20.
 */
public class ScheduleItem {

    public String date;
    public String title;
    public String content;
    public boolean isTitle;

    public ScheduleItem(String title, String date, String content){
        this.date = date;
        this.title = title;
        this.content = content;
        this.isTitle = false;
    }

    public ScheduleItem(String title){
        this.date = "";
        this.title = title;
        this.content = "";
        this.isTitle = true;
    }
}
