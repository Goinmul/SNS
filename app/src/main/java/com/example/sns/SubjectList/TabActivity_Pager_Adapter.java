package com.example.sns.SubjectList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/*

TabActivity -> here
adds four fragments

*/

public class TabActivity_Pager_Adapter extends FragmentStatePagerAdapter {

    int frag_count = 0;

    // constructor
    public TabActivity_Pager_Adapter(FragmentManager frag_manager, int frag_count) {
        super(frag_manager);
        this.frag_count = frag_count;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0 : return new TabFragment1();
            case 1 : return new TabFragment2();
            case 2 : return new TabFragment3();
            case 3 : return new TabFragment4();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return this.frag_count;
    }
}
