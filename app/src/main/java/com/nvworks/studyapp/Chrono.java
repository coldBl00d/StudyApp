package com.nvworks.studyapp;

import android.os.SystemClock;
import android.util.Log;
import android.widget.Chronometer;
import android.widget.TextView;


/**
 * Created by akhil on 9/3/2015.
 *
 * This class is the main Chronometer Manager class
 * Constructor :-
 *      1.A Chronometer Object
 *      2.TextView That Need To Be Updated
 *
 * Methods:-
 *      1.startClock [void]
 *          Starts the stopWatch from 0
 *          If Called more than one time the stopwatch resets every time snd starts from 0
 *      2.stopClock [Returns int array]
 *          stops the stopwatch
 *          Returns an array of format {hour,minute,seconds}
 *      3.pauseClock [Returns long]
 *          returns the pauseCorrection
 *          pass this to onResume when resuming the stopWatch
 *      4.resumeClock [void]
 *          param:- pauseCorrection
 *
 *
 */


public class Chrono  {


    private long countUp;
    private TextView timerView;
    private Chronometer chronometer = null;
    private long baseTime = 0L;
    private int hour;
    private int minute;
    private int second;


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
        chronometer.setBase(this.baseTime);
        chronometer.start();
    }

    public int[] stopClock (){
        int [] time = {hour,minute,second};
        this.baseTime= 0L;
        chronometer.stop();
        this.timerView.setText("0:00:00");
        return time;
    }

    public long pauseClock(){
        chronometer.stop();
        Log.d(this.getClass().getName(),"STOPING STOPWATCH");
        this.baseTime= 0L;
        return countUp;
    }

    public void resumeClock (long pauseCorrection){
        chronometer.setBase(SystemClock.elapsedRealtime()-pauseCorrection);
        chronometer.start();
        //Change this
    }



}
