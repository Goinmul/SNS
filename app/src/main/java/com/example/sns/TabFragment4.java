package com.example.sns;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sns.DB.GetData;
import com.example.sns.Model.Subject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment4 extends Fragment {

    GetData getdata = new GetData();
    ArrayList<Subject> subject = new ArrayList<Subject>();
    // sample data
    private ArrayList<String> mSubject = new ArrayList<>();

    // RecyclerView member variables
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public TabFragment4() {
        // Required empty public constructor
    }

    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // initialize sample data
        getdata.resultSubject(subject);
        for (int i = 0; i < subject.size(); i++) {
            if (subject.get(i).getGrade().equalsIgnoreCase("4")) {
                mSubject.add("(frag1)Subject " + subject.get(i).getSubject_name().toString());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_fragment1, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.frag1_recycler_view); // from content_tab_recycler_view.xml
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new WordListAdapter(getActivity(), mSubject); // context = getActivity()
        mLayoutManager = new LinearLayoutManager((getActivity()));
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

}
