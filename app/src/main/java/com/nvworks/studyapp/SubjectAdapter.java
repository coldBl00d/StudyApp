package com.nvworks.studyapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by akhil on 8/27/2015.
 */
public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubViewHolder> {

    String className = "DEBUG";

    LayoutInflater inflater;
    List<Subject> subjectList = Collections.emptyList();

    public SubjectAdapter (Context context,List<Subject> list)
    {
        inflater = LayoutInflater.from(context);
        subjectList= list;
        Log.d(className,"SubjectAdapter object passed");
    }

    @Override
    public SubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =inflater.inflate(R.layout.subject_row,parent,false);
        SubViewHolder viewHolder = new SubViewHolder(v);
        Log.d(className,"onCreateViewHolder -- Done");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SubViewHolder holder, int position) {
        Subject current = subjectList.get(position);
        Integer id =  current.getId();
        String sid = id.toString();

        holder.id.setText(sid);
        holder.name.setText(current.getName());
        Log.d(className,"Name and id set" );

    }

    /**
     * Returns the total number of items in the data set hold by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        Log.d(className,"getting count -  "+ subjectList.size());
        return subjectList.size();
    }

    class SubViewHolder extends RecyclerView.ViewHolder
    {
        TextView id,name;

        public SubViewHolder(View itemView) {
            super(itemView);

            id = (TextView) itemView.findViewById(R.id.subjectNumber);
            name = (TextView) itemView.findViewById(R.id.subjectName);

        }
    }
}
