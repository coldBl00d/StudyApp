package com.nvworks.studyapp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;



public class fStopWatch extends Fragment implements View.OnClickListener {

    TextView timerText;
    Button start,stop;
    ImageView image;
    Handler handler = new Handler();

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


        start = (Button) view.findViewById(R.id.startButton);
        start.setOnClickListener(this);
        image = (ImageView) view.findViewById(R.id.elipseImage);



        /**************************************************
         * *************VIEW INJECTIONS********************
         * ************************************************/
        return view;
    }


    /**
     * Called when a fragment is first attached to its activity.
     * {@link #onCreate(android.os.Bundle)} will be called after this.
     *
     * @param activity
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.startButton:
                getFragmentManager().beginTransaction().add(R.id.main_bottomFrag,new selectSchedule()).commit();
                break;
        }
    }
}
