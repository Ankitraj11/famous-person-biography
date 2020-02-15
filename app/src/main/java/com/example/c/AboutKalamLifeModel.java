package com.example.c;

public class AboutKalamLifeModel {
    int images;
    String currenttime;

    public AboutKalamLifeModel(int images, String currenttime) {
        this.images = images;
        this.currenttime = currenttime;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getCurrenttime() {
        return currenttime;
    }

    public void setCurrenttime(String currenttime) {
        this.currenttime = currenttime;
    }
}
