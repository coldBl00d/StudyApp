package com.nvworks.studyapp;

import android.os.Handler;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Akhil on 8/22/2015.
 * Use static member createStopWatch to create and return a single Stopwatch object 
 * Params :
 * UI thread Handler
 * Start Button id 
 * TextView id where the time is being displayed
 * stop button id // completely useless will remove it 
 */

public class StopWatch {

    private long startTime = 0L;
    private long timeInMillies = 0L;
    private long timeSwap = 0L;
    private long finalTime = 0L;



    private static StopWatch stopwatch=null;


    private Handler activityHandler;
    private TextView textTimer;
    private Button startButton;
    private Button stopButton;

    private StopWatch (Handler h,TextView t) {
        activityHandler = h;
        textTimer = t;



    }

    public static StopWatch createStopWatch(Handler h, TextView t) {
        if (stopwatch == null) {
            stopwatch = new StopWatch(h,t);
        }

        return stopwatch;
    }

    public void start ()
    {
        startTime = SystemClock.uptimeMillis();
        activityHandler.postDelayed(updateTimerMethod, 0);

    }

    public void pause() {
        timeSwap += timeInMillies;
        activityHandler.removeCallbacks(updateTimerMethod);

    }

    public void stop () {
        startTime =0L;
        timeSwap=0L;
        timeInMillies=0L;
        finalTime=0L;
        activityHandler.removeCallbacks(updateTimerMethod);
        textTimer.setText("0:00:00");
    }



    //Runnable for counting
    private Runnable updateTimerMethod = new Runnable() {

        public void run() {
            timeInMillies = SystemClock.uptimeMillis() - startTime;
            finalTime = timeSwap + timeInMillies;

            int seconds = (int) (finalTime / 1000);
            int minutes = seconds / 60;
            int hours = minutes/60;
            minutes = minutes%60;
            seconds = seconds % 60;
            int milliseconds = (int) (finalTime % 1000);
            textTimer.setText(""+hours+":" + String.format("%02d",minutes) + ":"
                    + String.format("%02d", seconds)
                    );
            activityHandler.postDelayed(this, 0);
        }

    };


}
