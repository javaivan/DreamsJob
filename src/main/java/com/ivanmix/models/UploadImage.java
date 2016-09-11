package com.ivanmix.models;

import java.io.Serializable;

public class UploadImage implements Serializable{

    private String smallImage;
    private String bigImage;

    public UploadImage(String smallImage, String bigImage){
        super();
        this.smallImage = smallImage;
        this.bigImage = bigImage;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }

    public String getBigImage() {
        return bigImage;
    }

    public void setBigImage(String bigImage) {
        this.bigImage = bigImage;
    }

    @Override
    public String toString() {
        return "UploadImage{" +
                "smallImage='" + smallImage + '\'' +
                ", bigImage='" + bigImage + '\'' +
                '}';
    }
}