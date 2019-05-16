package com.example.sns;

/// Class of recyclerView's adapter

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    // Data will be saved here.
    private ArrayList<String> subjects = new ArrayList<>();

    // for setting data
    public WordListAdapter(ArrayList<String> mData){
        this.subjects = mData;
    }

    // to create a view for a list(data), WordListAdapter needs to inflnflate the XML for a list item.
    // LayoutInflater does the job.
    // It reads a layout XML description and converts it into the corresponding View item.
    // (xml -> view)
    private LayoutInflater mInflater;

    // constructor
    public WordListAdapter(Context context, ArrayList<String> subjects){
        mInflater = LayoutInflater.from(context);
        this.subjects = subjects;
    }

    // inner class, a view holder for my adapter.
    // * onClick methods added. when clicking the subject, event occurs
    class WordViewHolder extends RecyclerView.ViewHolder {

        public WordViewHolder(View itemView, WordListAdapter adapter){
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word); // from recyclerview_single_word.xml in layout folder
            this.mAdapter = adapter;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), subjects.get(getAdapterPosition()) + " is clicked!", Toast.LENGTH_SHORT).show();

                    // real data
                    String class_name = "com.example.sns.Tab_RecyclerView";
                    try {
                        Intent intent = new Intent(v.getContext(), Class.forName(class_name));
                        v.getContext().startActivity(intent);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    /*Intent intent = new Intent(v.getContext(),Tab_RecyclerView.class);
                    v.getContext().startActivity(intent);*/
                }
            });
        }

        public final TextView wordItemView;
        final WordListAdapter mAdapter;
    }

    /* three methods overridden from RecyclerView.Adapter */
    @NonNull
    @Override
    // inflates the item layout(xml), and returns a ViewHolder with layout(+ and adapter ).
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View mItemView = mInflater.inflate(R.layout.recyclerview_single_word, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    // connects the string data to view holder. ( only for deploying data )
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder wordViewHolder, int position) {
        String mCurrent = subjects.get(position);
        wordViewHolder.wordItemView.setText(mCurrent);
    }

    // return the size of my data (subject quantity)
    @Override
    public int getItemCount() {
        return subjects.size();
    }

    // removing items
    public void removeItem(int position){
        subjects.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, subjects.size());
    }

    // adding items
    public void addItem(int position, String item ){
        subjects.add(position,item);
        notifyItemInserted(position);
        notifyItemRangeChanged(position, subjects.size());
    }
}
