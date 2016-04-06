package com.srmadt.attd0_1.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.srmadt.attd0_1.Adapter.TimeTableCard;
import com.srmadt.attd0_1.Adapter.TimetableFragmentAdapter;
import com.srmadt.attd0_1.MainActivity;
import com.srmadt.attd0_1.R;
import com.srmadt.attd0_1.Tabs.SlidingTabLayout;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimetableFragment extends android.support.v4.app.Fragment {

    TimeTableCard timeTableCard;
    ArrayList<TimeTableCard> timeTableCardArrayList;
    TimetableFragmentAdapter timetableFragmentAdapter;
    RecyclerView timetable_list;
    LinearLayoutManager linearLayoutManager;

    public TimetableFragment() {

        /*
        timeTableCard.subject_name="Programming Design and Development";
        timeTableCard.subject_details="Venue: Apple Lab, TechPark 8th Floor \nTeacher: My Teacher";
        timeTableCard.subject_icon=R.drawable.sidebar_card;

        for(int i=0;i<7;i++) timeTableCardArrayList.add(timeTableCard);
*/

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_timetable, container, false);
        Bundle bundle = getArguments();
        timetable_list = (RecyclerView) view.findViewById(R.id.timetable_list);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        timeTableCardArrayList = new ArrayList<TimeTableCard>();
        timeTableCard = new TimeTableCard();

        switch (bundle.getInt("dayOrder")) {
            case 1:
                timeTableCard.subject_name = "Programming Design and Development";
                timeTableCard.subject_details = "Day 1 \nVenue: Apple Lab, TechPark 8th Floor \nTeacher: My Teacher";
                timeTableCard.subject_icon = R.drawable.sidebar_card;

                for (int i = 0; i < 8; i++) timeTableCardArrayList.add(timeTableCard);
                break;
            case 2:
                timeTableCard.subject_name = "Programming Design and Development";
                timeTableCard.subject_details = "Day 2 \nVenue: Apple Lab, TechPark 8th Floor \nTeacher: My Teacher";
                timeTableCard.subject_icon = R.drawable.sidebar_card;

                for (int i = 0; i < 8; i++) timeTableCardArrayList.add(timeTableCard);
                break;
            case 3:
                timeTableCard.subject_name = "Programming Design and Development";
                timeTableCard.subject_details = "Day 3 \nVenue: Apple Lab, TechPark 8th Floor \nTeacher: My Teacher";
                timeTableCard.subject_icon = R.drawable.sidebar_card;

                for (int i = 0; i < 8; i++) timeTableCardArrayList.add(timeTableCard);
                break;
            case 4:
                timeTableCard.subject_name = "Programming Design and Development";
                timeTableCard.subject_details = "Day 4 \nVenue: Apple Lab, TechPark 8th Floor \nTeacher: My Teacher";
                timeTableCard.subject_icon = R.drawable.sidebar_card;

                for (int i = 0; i < 8; i++) timeTableCardArrayList.add(timeTableCard);
                break;
            case 5:
                timeTableCard.subject_name = "Programming Design and Development";
                timeTableCard.subject_details = "Day 5 \nVenue: Apple Lab, TechPark 8th Floor \nTeacher: My Teacher";
                timeTableCard.subject_icon = R.drawable.sidebar_card;

                for (int i = 0; i < 8; i++) timeTableCardArrayList.add(timeTableCard);
                break;
        }

        timetableFragmentAdapter = new TimetableFragmentAdapter(getActivity(), timeTableCardArrayList);
        timetable_list.setAdapter(timetableFragmentAdapter);
        timetable_list.setLayoutManager(linearLayoutManager);
        return view;
    }

    public static TimetableFragment getInstance(int dayOrder) {
        TimetableFragment timetableFragment = new TimetableFragment();
        Bundle args = new Bundle();
        args.putInt("dayOrder", dayOrder);
        timetableFragment.setArguments(args);
        return timetableFragment;
    }

}
