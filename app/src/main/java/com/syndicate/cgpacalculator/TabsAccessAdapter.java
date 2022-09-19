package com.syndicate.cgpacalculator;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabsAccessAdapter extends FragmentPagerAdapter {


    public TabsAccessAdapter(FragmentManager fm) {

        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                CalcsFragment calcsFragment = new CalcsFragment();
                return calcsFragment;
            case 1:
                DeptListFragment deptListFragment = new DeptListFragment();
                return deptListFragment;
            case 2:
                CgpaFragment cgpaFragment = new CgpaFragment();
                return cgpaFragment;


            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0:
                return "CALC";
            case 1:
                return "GPA";
            case 2:
                return "CGPA";
            default:
                return null;
        }

    }
}
