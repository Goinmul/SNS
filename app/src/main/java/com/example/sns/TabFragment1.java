package com.example.sns;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

import com.example.sns.DB.GetData;
import com.example.sns.Model.Subject;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment1 extends Fragment {

    GetData getdata = new GetData();
    ArrayList<Subject> subject = new ArrayList<Subject>();

    // arrayList for my adapter (this will contain 'subject' data as string)
    private ArrayList<String> mSubject = new ArrayList<>();

    // RecyclerView member variables
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager; // for using getActivity() method

    public TabFragment1() {
        // Required empty public constructor
    }

    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // initialize real data.
        getdata.resultSubject(subject);
        for (int i = 0; i < subject.size(); i++) {
            if (subject.get(i).getGrade().equalsIgnoreCase("1")) {
                mSubject.add(subject.get(i).getSubject_name().toString());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tab_fragment1, container, false);

        /* creates recycler view and connects it with an adapter + data. */
        // 1) instantiate recyclerView
        mRecyclerView = (RecyclerView) view.findViewById(R.id.frag1_recycler_view); // from content_tab_recycler_view.xml
        mRecyclerView.setHasFixedSize(true);

        // 2) instantiate adapter
        mAdapter = new WordListAdapter(getActivity(), mSubject); // context = getActivity()

        mLayoutManager = new LinearLayoutManager((getActivity()));
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        // 3) connect adapter <-> recyclerView
        mRecyclerView.setAdapter(mAdapter);

        // set intent
        //Intent intent = new Intent(view.getContext(), Tab_RecyclerView.class);
        //view.getContext().startActivity(intent);

        //mRecyclerView.scrollToPosition(0); // reset
        //mRecyclerView.setItemAnimator(new DefaultItemAnimator()); // additional

        return view;
        //return inflater.inflate(R.layout.fragment_tab_fragment1, container, false);
    }


}
