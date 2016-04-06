package com.srmadt.attd0_1.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.srmadt.attd0_1.R;

import java.util.List;

/**
 * Created by Rishi on 3/22/2016.
 */
public class TimetableFragmentAdapter extends RecyclerView.Adapter<TimetableFragmentAdapter.MyViewHolder> {

    List<TimeTableCard> timetable_list;
    private Context context;
    private int lastPosition = -1;

    public TimetableFragmentAdapter(Context context, List<TimeTableCard> timetable_list) {
        this.context = context;
        this.timetable_list = timetable_list;
    }

    @Override
    public TimetableFragmentAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.fragment_timetable_card, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TimetableFragmentAdapter.MyViewHolder holder, int position) {

        TimeTableCard current = timetable_list.get(position);
        holder.subject_icon.setImageResource(current.subject_icon);
        holder.subject_name.setText(current.subject_name);
        holder.subject_details.setText(current.subject_details);
        holder.bt_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Details yet to come :D", Toast.LENGTH_SHORT).show();
                //context.startActivity(new Intent(context, CalendarView.class));

            }
        });

        setAnimation(holder.timetable_cardview, position);
    }

    @Override
    public int getItemCount() {
        return timetable_list.size();
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.slide_up);
            animation.setInterpolator(context,android.R.anim.accelerate_decelerate_interpolator);
            animation.setDuration(600);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView subject_icon;
        TextView subject_name;
        TextView subject_details;
        Button bt_details;
        CardView timetable_cardview;

        public MyViewHolder(View itemView) {
            super(itemView);
            timetable_cardview= (CardView) itemView.findViewById(R.id.timetable_cardview);
            subject_icon = (ImageView) itemView.findViewById(R.id.timetable_icon);
            subject_name = (TextView) itemView.findViewById(R.id.timetable_subject_name);
            subject_details = (TextView) itemView.findViewById(R.id.timetable_subject_details);
            bt_details = (Button) itemView.findViewById(R.id.timetable_bt_details);
        }
    }
}
