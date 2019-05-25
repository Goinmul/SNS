package com.example.sns;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.sns.R;
import com.example.sns.SubjectList.WordListAdapter;

import java.util.ArrayList;

public class Tab_RecyclerView extends AppCompatActivity {

    // sample data
    private final ArrayList<String> mSubject = new ArrayList<>();

    // RecyclerView member variables
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab__recycler_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        setTitle("Data Structure");

        // initialize sample data
        for (int i = 0; i < 20; i++) {
            mSubject.add("data structure link " + i);
        }
        // creates recycler view and connects it with an adapter + data.
        // 1) instantiate recyclerView
        mRecyclerView = findViewById(R.id.recyclerview); // from content_tab_recycler_view.xml

        // 2) instantiate adapter
        mAdapter = new WordListAdapter(this, mSubject);

        // 3) connect adapter <-> recyclerView
        mRecyclerView.setAdapter(mAdapter);

        // 4) now RecyclerView is a default layout for this activity
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // floating button
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "My Action here", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
