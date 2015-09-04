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


public class fStopWatch extends Fragment implements View.OnClickListener {

    private Chrono stopWatch;
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

        /**************************************************
         * *************VIEW INJECTIONS********************
         * ************************************************/


        start = (ImageButton) view.findViewById(R.id.startButton);
        start.setOnClickListener(this);
        timerText = (TextView) view.findViewById(R.id.timerView);
        Chronometer  chronometer =(Chronometer) view.findViewById(R.id.chronometer);


        /**************************************************
         * *************VIEW INJECTIONS********************
         * ************************************************/
        stopWatch = new Chrono(chronometer, timerText);

         return view;
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);


    }


    @Override
    public void onPause() {
        Log.d(this.getClass().getName(),"Calling onPause()");
        super.onPause();

    }

    /**
     * Called when the fragment is no longer in use.  This is called
     * after {@link #onStop()} and before {@link #onDetach()}.
     */
    @Override
    public void onDestroy() {
        Log.d(this.getClass().getName(),"Calling onDestroy ()");
        super.onDestroy();
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.d(this.getClass().getName(),"Calling onResume)");

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
