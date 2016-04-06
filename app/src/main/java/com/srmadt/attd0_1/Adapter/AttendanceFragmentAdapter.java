package com.srmadt.attd0_1.Adapter;

import android.content.Context;
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

import com.srmadt.attd0_1.R;

import java.util.List;


/**
 * Created by Rishi on 3/22/2016.
 */
public class AttendanceFragmentAdapter extends RecyclerView.Adapter<AttendanceFragmentAdapter.MyViewHolder> {

    List<AttendanceCard> attendanceCardList;
    Context context;
    private int lastPosition = -1;

    public AttendanceFragmentAdapter(Context context, List<AttendanceCard> attendanceCardList) {
        this.context = context;
        this.attendanceCardList = attendanceCardList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_attendance_card, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.setData(attendanceCardList.get(position));
        setAnimation(holder.attendance_cardview, position);

    }


    @Override
    public int getItemCount() {
        return attendanceCardList.size();
    }

    public void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.slide_in_right);
            animation.setInterpolator(context,android.R.anim.anticipate_overshoot_interpolator);
            animation.setDuration(600);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView subject_icon;
        TextView subject_name;
        TextView subject_code;
        TextView present;
        TextView total_class;
        TextView attendance_percentage;
        CardView attendance_cardview;

        public MyViewHolder(View itemView) {
            super(itemView);

            attendance_cardview= (CardView) itemView.findViewById(R.id.attendance_cardview);
            subject_icon = (ImageView) itemView.findViewById(R.id.img_sub_icon);
            subject_name = (TextView) itemView.findViewById(R.id.txt_sub_name);
            subject_code = (TextView) itemView.findViewById(R.id.txt_sub_code);
            present = (TextView) itemView.findViewById(R.id.txt_class_attnd);
            total_class = (TextView) itemView.findViewById(R.id.txt_class_tot);
            attendance_percentage = (TextView) itemView.findViewById(R.id.txt_attnd_per);
        }

        public void setData(AttendanceCard data) {
            subject_icon.setImageResource(data.subject_icon);
            subject_name.setText(data.subject_name);
            subject_code.setText("" + data.subject_code);
            present.setText("Present: " + data.present);
            total_class.setText("Total Hours" + data.total_class);
            attendance_percentage.setText("Attendance %: " + data.attendance_percentage);

        }
    }
}
