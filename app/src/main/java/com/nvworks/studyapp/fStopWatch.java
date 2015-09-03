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

    TextView timerText;
    Button stop;
    ImageButton start;
    ImageView image;
    long baseTime;
    long upTime;
    SharedPreferences preferences;
    boolean checkRunningPending=false;
    NotificationManager nm;



    Handler handler = new Handler ();
    private Chrono stopWatch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f_stop_watch, container, false);
        preferences = getActivity().getSharedPreferences("BASE_TIME",getActivity().MODE_PRIVATE);
        checkRunningPending = preferences.getBoolean("RUNNING_PENDING",false);

        /**************************************************
         * *************VIEW INJECTIONS********************
         * ************************************************/


        start = (ImageButton) view.findViewById(R.id.startButton);
        start.setOnClickListener(this);
        timerText = (TextView) view.findViewById(R.id.timerView);
        Chronometer  chronometer =(Chronometer) view.findViewById(R.id.chronometer);
        nm = (NotificationManager) getActivity().getSystemService(getActivity().NOTIFICATION_SERVICE);


        /**************************************************
         * *************VIEW INJECTIONS********************
         * ************************************************/
        stopWatch = new Chrono(chronometer, timerText);
        if (checkRunningPending){
            stopWatch.setBaseTime(preferences.getLong("baseTime",0L));
            stopWatch.startClock();
        }

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
        if (stopWatch.getIsRunning()){
            Log.d(this.getClass().getName(),"Stop watch base time :"+ stopWatch.getBaseTime());
            SharedPreferences.Editor editor = preferences.edit();
            editor.putLong("BASE_TIME",stopWatch.getBaseTime());
            editor.apply();
            editor.putBoolean("RUNNING_PENDING",true);
            editor.apply();
            Log.d(this.getClass().getName(),"Preference values-->"+preferences.getLong("BASE_TIME",0L)+" \n"+preferences.getBoolean("RUNNING_PENDING",false));
        }
        super.onDestroy();
    }

    /**
     * Called when the fragment is visible to the user and actively running.
     * This is generally
     * tied to {@link android.app.Activity#onResume() Activity.onResume} of the containing
     * Activity's lifecycle.
     */
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

                getFragmentManager().beginTransaction().add(R.id.main_bottomFrag,new selectSchedule()).commit();  //---- Starts the select sub frag
                stopWatch.startClock();
                break;
        }
    }
}
