package com.nvworks.studyapp;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Chronometer;
import android.widget.TextView;

/**
 * Created by akhil on 9/3/2015.
 */


public class Chrono  {

    private final TextView timerView;
    /**
     * This Class will always return
     */


    private Chronometer chronometer = null;
    private long baseTime = 0L;
    //private long elapsedTimeBeforePause = 0L;
    private long countUp;
    private int hour;
    private int minute;
    private int second;
    private boolean isRunning= false;


    public Chrono (Chronometer chronometer,final TextView timerView){
        this.chronometer = chronometer;
        this.timerView = timerView;

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                countUp = (SystemClock.elapsedRealtime()-chronometer.getBase());
                second = (int) (countUp/1000);
                minute = second/60;
                second = second%60;
                hour= minute/60;
                minute = minute%60;

                timerView.setText("" + hour + ":" + String.format("%02d", minute) + ":"
                                + String.format("%02d", second)

                );
            }
        });
    }

    public void startClock (){
        this.baseTime = SystemClock.elapsedRealtime();
        Log.d(this.getClass().getName(),"BASE TIME-->"+baseTime);
        isRunning = true;
        chronometer.setBase(this.baseTime);
        chronometer.start();

    }

    public boolean getIsRunning(){
        return isRunning;
    }

    public long getBaseTime (){
        return baseTime;
    }

    public void setBaseTime(long base){
        this.baseTime = base;
    }

}
