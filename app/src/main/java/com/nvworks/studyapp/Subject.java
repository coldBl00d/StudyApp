package com.nvworks.studyapp;

import android.graphics.Bitmap;

/**
 * Created by akhil on 8/27/2015.
 */
public class Subject {
    private int id;
    private String name;
    private Bitmap image=null;

    public Subject(int i, String name)
    {
        id = i;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
