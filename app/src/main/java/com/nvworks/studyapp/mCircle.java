package com.nvworks.studyapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;


/**
 * Created by akhil on 8/21/2015.
 */
public class mCircle extends View {

    Paint paint = new Paint();

    public mCircle (Context context){
        super(context);
    }

    @Override
    public void onDraw (Canvas canvas){
        paint.setColor(Color.WHITE);
        View v = new View(getContext());
        OvalShape o = new OvalShape();



   }

}
