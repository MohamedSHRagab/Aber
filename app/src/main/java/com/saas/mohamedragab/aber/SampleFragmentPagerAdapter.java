package com.saas.mohamedragab.aber;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
       private String Days[] = new String[] {"Sat","Sun","Mon","Tue","Wed","Thr","Fri"};
    private String Numbers[] = new String[] {"16","17","18","19","20","21","22"};

    final int PAGE_COUNT = Days.length;

        private Context context;

        public SampleFragmentPagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public Fragment getItem(int position) {
            return PageFragment.newInstance(position + 1);
        }



        public View getTabView(int position) {
            // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
            View v = LayoutInflater.from(context).inflate(R.layout.date_info, null);
            TextView day = (TextView) v.findViewById(R.id.day);
            TextView number = (TextView) v.findViewById(R.id.number);

            day.setText(Days[position]);
            number.setText(Numbers[position]);

            return v;
        }
    }

