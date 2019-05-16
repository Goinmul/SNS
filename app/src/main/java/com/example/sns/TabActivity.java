package com.example.sns;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.sns.DB.GetData;
import com.example.sns.Model.Comment;
import com.example.sns.Model.Post;
import com.example.sns.Model.Subject;
import com.example.sns.Model.User;

/*
Main page with four grade(freshman, sophomore, ...) buttons
 */
public class TabActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        GetData data = new GetData();

        User user = new User();
        Subject subject = new Subject();
        Post post = new Post();
        Comment comment = new Comment();

        data.result(user);
        data.result(subject);
        data.result(post);
        data.result(comment);


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
