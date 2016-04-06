package com.srmadt.attd0_1;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.srmadt.attd0_1.Tabs.SlidingTabLayout;
import com.srmadt.attd0_1.fragments.AttendanceFragment;
import com.srmadt.attd0_1.fragments.TimetableFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager pager;
    private SlidingTabLayout tabs;
    LinearLayout my_layout, timetable_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        my_layout = (LinearLayout) findViewById(R.id.my_layout);
        my_layout.setVisibility(View.INVISIBLE);


        timetable_layout = (LinearLayout) findViewById(R.id.timetable_layout);


        pager = (ViewPager) findViewById(R.id.pager);

        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        tabs.setSelectedIndicatorColors(R.color.colorAccent);
        tabs.setViewPager(pager);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        my_layout.setVisibility(View.INVISIBLE);
        timetable_layout.setVisibility(View.INVISIBLE);
        if (id == R.id.nav_timetable) {
            timetable_layout.setVisibility(View.VISIBLE);
        } else if (id == R.id.nav_attendance) {
            my_layout.setVisibility(View.VISIBLE);
            AttendanceFragment attendanceFragment = new AttendanceFragment();
            transaction.replace(R.id.my_layout, attendanceFragment, "Attendance");
        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_credits) {

        }
        transaction.commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    class MyPagerAdapter extends FragmentPagerAdapter {
        String[] tabs;


        public MyPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
            tabs = getResources().getStringArray(R.array.tab_days);
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            //MyFragment myFragment = MyFragment.getInstance(position);
            TimetableFragment timetableFragment=TimetableFragment.getInstance(position+1);
            return timetableFragment;
        }

        @Override
        public int getCount() {
            return 5;
        }
    }

   /*
    public static class MyFragment extends android.support.v4.app.Fragment {
        private TextView textView;

        public static MyFragment getInstance(int position) {
            MyFragment myFragment = new MyFragment();
            Bundle args = new Bundle();
            args.putInt("position", position);
            myFragment.setArguments(args);
            return myFragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            // return super.onCreateView(inflater, container, savedInstanceState);
            View layout = inflater.inflate(R.layout.fragment_day_order, container, false);
            Bundle bundle = getArguments();
            textView = (TextView) layout.findViewById(R.id.txt_position);
            if (bundle != null) {
                textView.setText("Tab " + bundle.getInt("position"));
            }
            return layout;
        }
    }

    */

}
