package com.example.c;

public class KalamLifeRecyclerViewModel {
     int images;
     String text;

    public KalamLifeRecyclerViewModel(int images, String text) {
        this.images = images;
        this.text = text;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
