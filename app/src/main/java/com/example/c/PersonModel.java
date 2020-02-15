package com.example.c;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonModel  {
    String name;
    String profession;
    int image;


    public PersonModel(String name, String profession, int image) {
        this.name = name;
        this.profession = profession;
        this.image=image;

    }




    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}

