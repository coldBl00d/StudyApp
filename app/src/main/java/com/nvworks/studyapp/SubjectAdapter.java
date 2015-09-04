package com.nvworks.studyapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.Collections;
import java.util.List;

/**
 * Created by akhil on 8/27/2015.
 */
public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubViewHolder> {

    public static final int ICON_HEIGHT = 100;
    public static final int ICON_WIDTH = 100;

    private LayoutInflater inflater;
    private List<Subject> subjectList = Collections.emptyList();
    private TextDrawable drawable;
    private ColorGenerator colorGenerator = ColorGenerator.MATERIAL;



    public SubjectAdapter (Context context,List<Subject> list) {
        inflater = LayoutInflater.from(context);
        subjectList= list;
    }



    @Override
    public SubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =inflater.inflate(R.layout.subject_row,parent,false);
        SubViewHolder viewHolder = new SubViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SubViewHolder holder, int position) {

        String firstLetter;
        int color;

        Subject current = subjectList.get(position);
        holder.name.setText(current.getName());
        firstLetter = current.getName().substring(0,1);
        color = colorGenerator.getColor(current.getName());
        drawable=TextDrawable.builder().beginConfig().width(ICON_WIDTH).height(ICON_HEIGHT).endConfig().buildRound(firstLetter, color);
        holder.icon.setImageDrawable(this.drawable);
    }


    @Override
    public int getItemCount() {
        return subjectList.size();
    }

    class SubViewHolder extends RecyclerView.ViewHolder
    {
        TextView name;
        ImageView icon;

        public SubViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.subjectName);
            icon = (ImageView) itemView.findViewById(R.id.iconView);
        }
    }
}
