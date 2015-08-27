package com.nvworks.studyapp;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class selectSchedule extends Fragment {

    String className = "DEBUG";

    private SubjectAdapter subjectAdapter;
    private RecyclerView recyclerView;
    public selectSchedule() {
        Log.d(className,"Constructing/");
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_select_schedule, container, false);
        Log.d(className,"Gonna create the recycler view" );
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        subjectAdapter = new SubjectAdapter(getActivity(),getSubjects());
        Log.d(className,"Subject adapter recieved");
        recyclerView.setAdapter(subjectAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        return v;
    }


    public static List<Subject> getSubjects (){
        List<Subject> subjectList = new ArrayList<>();
        int[] id={1,2,3,4};
        String [] subjects = {"Math","English","Physics","Chemistry"};
        for (int i = 0 ; i < id.length ; i  ++ )
        {
            Subject current = new Subject(id[i],subjects[i]);
            subjectList.add(current);
        }

        return subjectList;

    }


}
