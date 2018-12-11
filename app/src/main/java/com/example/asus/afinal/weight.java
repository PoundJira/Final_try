package com.example.asus.afinal;

import android.content.ContentValues;

public class weight {
    private String date;
    private String weight;
    ContentValues convalue = new ContentValues();

    public weight(String date,String weight){
        this.date=date;
        this.weight=weight;
    }
    public weight(){

    }



    public void setConvalue(String date,String weight) {
        this.convalue.put("date",date);
        this.convalue.put("weight",weight);
    }

    public ContentValues getConvalue() {
        return convalue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
