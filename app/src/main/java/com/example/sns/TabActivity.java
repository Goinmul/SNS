package com.example.sns;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class TabActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tab);

            initTab();
            initViewPager();
    }

    private void initViewPager(){

        viewPager = findViewById(R.id.view_pager);

        pagerAdapter = new TabActivity_Pager_Adapter(getSupportFragmentManager(), 4); // Adapter for 4 fragments

        viewPager.setAdapter(pagerAdapter); // linked! (plug Adapter into ViewPager)

        // #1 swipe (drag)
        viewPager.addOnPageChangeListener(new
                TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    private void initTab(){

        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Freshman"));
        tabLayout.addTab(tabLayout.newTab().setText("Sophomore"));
        tabLayout.addTab(tabLayout.newTab().setText("Junior"));
        tabLayout.addTab(tabLayout.newTab().setText("Senior"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL); // similar to 'weight' attribute.

        // #IMPLEMENT : CLICK TAB EVENT HANDLER
        // ex) show toast message

        // #2 click
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                // alert viewPager which number is handed over, information given by 'tab'
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
