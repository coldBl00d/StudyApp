package com.nvworks.studyapp;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class fStopWatch extends Fragment implements View.OnClickListener {

    TextView timerText;
    Button stop;
    ImageButton start;
    ImageView image;


    Handler handler = new Handler ();
    private StopWatch stopWatch;

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



        /**************************************************
         * *************VIEW INJECTIONS********************
         * ************************************************/
        stopWatch = StopWatch.createStopWatch(handler,timerText);
         return view;
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onPause() {
        super.onPause();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.startButton:

                getFragmentManager().beginTransaction().add(R.id.main_bottomFrag,new selectSchedule()).commit();  //---- Starts the select sub frag
                stopWatch.start();                                                                                //----Starts the stopWatch
                break;
        }
    }
}
