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


public class selectSchedule extends Fragment {
    private SubjectAdapter subjectAdapter;
    private RecyclerView recyclerView;

    public selectSchedule() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_select_schedule, container, false);
        setupRecyclerView(v);
        return v;
    }

    private void setupRecyclerView(View recyclerContainer) {
        recyclerView = (RecyclerView) recyclerContainer.findViewById(R.id.recyclerView);
        subjectAdapter = new SubjectAdapter(getActivity(),getSubjects());
        recyclerView.setAdapter(subjectAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


    //------------------------------Dummy Data --------------------------------------------------
    public static List<Subject> getSubjects (){
        List<Subject> subjectList = new ArrayList<>();
        int[] id={1,2,3,4,5,6};
        String [] subjects = {"Math","English","Physics","Chemistry","Biology","Hindi"};
        for (int i = 0 ; i < id.length ; i  ++ ) {
            Subject current = new Subject(id[i],subjects[i]);
            subjectList.add(current);
        }
        return subjectList;
    }

}
