package com.srmadt.attd0_1.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.srmadt.attd0_1.Adapter.AttendanceCard;
import com.srmadt.attd0_1.Adapter.AttendanceFragmentAdapter;
import com.srmadt.attd0_1.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttendanceFragment extends Fragment {


    ArrayList<AttendanceCard> attendanceCardArrayList;
    AttendanceFragmentAdapter attendanceFragmentAdapter;
    RecyclerView subject_list;
    LinearLayoutManager linearLayoutManager;

    public AttendanceFragment() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_attendance, container, false);
        subject_list= (RecyclerView) view.findViewById(R.id.subject_list);
        linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        attendanceCardArrayList=new ArrayList<AttendanceCard>();
        AttendanceCard attendanceCard=new AttendanceCard();
        attendanceCard.subject_name="Programming Design and Development";
        attendanceCard.subject_code="15CS102";
        attendanceCard.subject_icon=R.drawable.sidebar_card;
        attendanceCard.present=8;
        attendanceCard.total_class=10;
        attendanceCard.attendance_percentage= (float) 80.0;

        for(int i=0;i<7;i++) attendanceCardArrayList.add(attendanceCard);

        attendanceFragmentAdapter=new AttendanceFragmentAdapter(getActivity(),attendanceCardArrayList);
        subject_list.setAdapter(attendanceFragmentAdapter);
        subject_list.setLayoutManager(linearLayoutManager);
        return view;
    }

}
