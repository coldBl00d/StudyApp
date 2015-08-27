package com.nvworks.studyapp;

import android.graphics.Bitmap;

/**
 * Created by akhil on 8/27/2015.
 */
public class Subject {
    private int id;
    private int name;
    private Bitmap image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
