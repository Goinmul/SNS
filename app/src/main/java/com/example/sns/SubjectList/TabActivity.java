package com.example.sns.SubjectList;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.sns.DB.GetData;
import com.example.sns.DB.SetData;
import com.example.sns.Model.Comment;
import com.example.sns.Model.Post;
import com.example.sns.Model.Subject;
import com.example.sns.Model.User;
import com.example.sns.R;

import java.util.ArrayList;

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

        Intent intent = getIntent();


        GetData getdata = new GetData();
        SetData setdata = new SetData();

        ArrayList<User> user = new ArrayList<User>();
        ArrayList<Subject> subject = new ArrayList<Subject>();
        ArrayList<Post> post = new ArrayList<Post>();
        ArrayList<Comment> comment = new ArrayList<Comment>();

        getdata.resultUser(user);
        getdata.resultSubject(subject);
        getdata.resultPost(post);
        getdata.resultComment(comment);

        /*
        StringBuffer usersb = new StringBuffer(); //StringBuffer - log.d까지 다 데이터를 가져왔는지 테스트
        StringBuffer subsb = new StringBuffer();
        StringBuffer postsb = new StringBuffer();
        StringBuffer commentsb = new StringBuffer();

        for (int i = 0; i < user.size(); i++) {
            Log.d("user for test", "" + user.get(i).getIndex());
            usersb.append( //test를 위한 용도
                    "\n" +
                            "인덱스:" + user.get(i).getIndex() +
                            "이름:" + user.get(i).getUser_name() +
                            "아이디:" + user.get(i).getUser_id() +
                            "비밀번호:" + user.get(i).getUser_pw() +
                            "학번:" + user.get(i).getUser_num() + "\n"
            );
        }

        Log.d("testuser", usersb.toString()); //test를 위한 용도

        for (int i = 0; i < subject.size(); i++) {
            subsb.append( //test를 위한 용도
                    "\n" +
                            "인덱스:" + subject.get(i).getIndex() +
                            "학번:" + subject.get(i).getGrade() +
                            "이름:" + subject.get(i).getSubject_name() + "\n"
            );
        }

        Log.d("testsub", subsb.toString()); //test를 위한 용도

        for (int i = 0; i < post.size(); i++) {
            postsb.append( //test를 위한 용도
                    "\n" +
                            "인덱스:" + post.get(i).getIndex() +
                            "과목:" + post.get(i).getSubject_name() +
                            "아이디:" + post.get(i).getUser_id() +
                            "제목:" + post.get(i).getTitle() +
                            "내용:" + post.get(i).getContent() +
                            "날짜:" + post.get(i).getEdit_date() +
                            "like:" + post.get(i).getLike_count() +
                            "점수:" + post.get(i).getPoint() +
                            "점수합:" + post.get(i).getPoint_sum() +
                            "점수갯수:" + post.get(i).getPoint_count() +
                            "조회수:" + post.get(i).getView_count() + "\n"
            );

        }

        Log.d("testpost", postsb.toString()); //test를 위한 용도

        for (int i = 0; i < comment.size(); i++) {
            Log.d("COmment size", ""+comment.size());
            commentsb.append( //test를 위한 용도
                    "\n" +
                            "인덱스:" + comment.get(i).getIndex() +
                    "과목인덱스:" + comment.get(i).getPost_index() +
                    "아이디:" + comment.get(i).getUser_id() +
                    "내용:" + comment.get(i).getContent() +
                    "날짜:" + comment.get(i).getEdit_date() +
                    "like:" + comment.get(i).getLike_count() + "\n"
        );

        }

        Log.d("testcomment", commentsb.toString()); //test를 위한 용도
        */

//      setdata.signUp("haha", "5555", "hh", 12341234);  // user_id, user_pw, user_name, user_num
//      setdata.writePost("CapStone", "haha", "Fortest", "testtest"); // subject_name, user_id, title. content
//      setdata.editPost("Data Structure", "Fortest2", "test2", 3); // subject_name, title, content, index
//      setdata.deletePost(3); // index
//      setdata.likePost(3); // index
//      setdata.pointPost(2, 8, 5, 2); // 입력할 point, point_sum, point_count, index
//      setdata.viewPost(3); // index
//      setdata.writeComment(3, "haha", "test1"); // post_index, user_id, content
//      setdata.editComment("test2", 3); // content, index
//      setdata.deleteComment(3); // index
//      setdata.likeComment(3); // index

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
