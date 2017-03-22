package com.example.wx.wechat;

/**
 * Created by wx on 17/3/21.
 */

public class Beans {
    private int  imageId;
    private  String name;
    private String date;
    public  Beans(String name,int imageId,String date)
    {
        this.name=name;
        this.imageId=imageId;
        this.date=date;
    }


    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
