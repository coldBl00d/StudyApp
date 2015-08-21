package com.nvworks.studyapp;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class Timer extends Fragment {


    public Timer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RelativeLayout r = (RelativeLayout) container.findViewById(R.id.timerRelative);
        r.addView(new mCircle(getActivity()));
        return inflater.inflate(R.layout.fragment_timer, container, false);
    }


}
