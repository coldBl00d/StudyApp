package com.nvworks.studyapp;

import android.os.Handler;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by akhil on 8/22/2015.
 * Use static member createStopWatch to create and return a single Stopwatch object 
 * Params :
 * UI thread Handler
 * Start Button id 
 * TextView id where the time is being displayed
 * stop button id // completely useless will remove it 
 */

public class StopWatch {

    private long startTime = 0L;
    long timeInMillies = 0L;
    long timeSwap = 0L;
    long finalTime = 0L;
    private static StopWatch stopwatch=null;
    public Handler activityHandler;
    private TextView textTimer;
    private Button startButton;
    private Button stopButton;

    private StopWatch (Handler h,TextView t,Button sp,Button st) {
        activityHandler = h;
        textTimer = t;
        startButton=sp;
        stopButton=st;


    }

    public static StopWatch createStopWatch(Handler h, TextView t,Button sp,Button st) {
        if (stopwatch == null) {
            stopwatch = new StopWatch(h,t,sp,st);
        }

        return stopwatch;
    }

    public void start ()
    {
        startTime = SystemClock.uptimeMillis();
        activityHandler.postDelayed(updateTimerMethod, 0);
        startButton.setText("Pause");
    }

    public void pause() {
        timeSwap += timeInMillies;
        activityHandler.removeCallbacks(updateTimerMethod);
        startButton.setText("Resume");
    }

    public void stop () {
        startTime =0L;
        timeSwap=0L;
        timeInMillies=0L;
        finalTime=0L;
        activityHandler.removeCallbacks(updateTimerMethod);
        startButton.setText("Start");
        textTimer.setText("0:00:000");
    }

    private Runnable updateTimerMethod = new Runnable() {

        public void run() {
            timeInMillies = SystemClock.uptimeMillis() - startTime;
            finalTime = timeSwap + timeInMillies;

            int seconds = (int) (finalTime / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;
            int milliseconds = (int) (finalTime % 1000);
            textTimer.setText("" + minutes + ":"
                    + String.format("%02d", seconds) + ":"
                    + String.format("%03d", milliseconds));
            activityHandler.postDelayed(this, 0);
        }

    };


}
