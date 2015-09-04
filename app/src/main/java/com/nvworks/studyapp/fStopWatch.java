package com.nvworks.studyapp;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Injections (View view)
 *        Write every UI component binding methods such as findViewById
 *        and Binding Listeners to the component there
 *        TO KEEP CODE CLEAN
 */


public class fStopWatch extends Fragment implements View.OnClickListener {

    private Chrono stopWatch;
    private Chronometer chronometer;
    private Handler handler = new Handler ();
    private TextView timerText;
    private ImageButton start;
    private ImageView image;
    private  long pauseCorrection=0L;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f_stop_watch, container, false);
        Injections(view);
        stopWatch = new Chrono(chronometer, timerText);
        return view;
    }

    //Bind all the view components here
    private void Injections(View view) {
        start = (ImageButton) view.findViewById(R.id.startButton);
        start.setOnClickListener(this);
        timerText = (TextView) view.findViewById(R.id.timerView);
        chronometer =(Chronometer) view.findViewById(R.id.chronometer);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.startButton:
                    getFragmentManager().beginTransaction().add(R.id.main_bottomFrag, new selectSchedule()).commit();  //---- Starts the select sub frag
                    stopWatch.startClock();
                break;
        }
    }
}
