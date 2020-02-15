package com.example.c;

public class EinsteinRecyclerViewModel {
   int images;
   String lifestatus;

    public EinsteinRecyclerViewModel(int images, String lifestatus) {
        this.images = images;
        this.lifestatus = lifestatus;
    }


    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getLifestatus() {
        return lifestatus;
    }

    public void setLifestatus(String lifestatus) {
        this.lifestatus = lifestatus;
    }
}
