package com.example.sns;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PostViewActivity extends AppCompatActivity {
    private ArrayList<CommentActivity> mArrayList;
    private CustomAdapter2 mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postview);

        Intent intent = getIntent() ;
        TextView writer = (TextView) findViewById(R.id.editText7) ;
        String viewWriter= intent.getStringExtra("contact_writer") ;
        if(viewWriter!=null) writer.setText(viewWriter) ;

        TextView title = (TextView) findViewById(R.id.editText6) ;
        String viewTitle = intent.getStringExtra("contact_title") ;
        if(viewTitle!=null) title.setText(viewTitle) ;

        TextView content = (TextView) findViewById(R.id.post_contents_text) ;
        String viewContent = intent.getStringExtra("contact_content") ;
        if(viewContent!=null) content.setText(viewContent);

        final EditText editTextName = (EditText) findViewById(R.id.editText5) ;
        final EditText editTextContents = (EditText) findViewById(R.id.editText4) ;

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_main_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mArrayList = new ArrayList<>();

        mAdapter = new CustomAdapter2(this, mArrayList);
        mRecyclerView.setAdapter(mAdapter);

        Button buttonInsert = (Button)findViewById(R.id.button6);
        Button buttonIntent = (Button)findViewById(R.id.button3);
        Button buttonstar = (Button)findViewById(R.id.button2) ;
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strName = editTextName.getText().toString();
                String strContents = editTextContents.getText().toString() ;

                CommentActivity com = new CommentActivity(strName, strContents) ;

                mArrayList.add(com) ;
                mAdapter.notifyDataSetChanged();
            }
        });
        buttonIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(PostViewActivity.this, PostListActivity.class) ;
                startActivity(intent1) ;
            }
        });
        final int[] selectedItem = {0} ;
        final String[] items = {"5.0", "4.5", "4.0", "3.5", "3.0", "2.5", "2.0", "1.5", "1.0", "0.5"} ;
        buttonstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PostViewActivity.this);
                builder.setTitle("Choose star point");
                builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selectedItem[0] = which ;
                    }
                });

                builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(PostViewActivity.this, items[selectedItem[0]], Toast.LENGTH_SHORT).show() ;
                        dialog.dismiss();
                    }
                });
                builder.create() ;
                builder.show();
            }
        });

        /*mAdapter.setItemClick(new CustomAdapter.ItemClick() {
            @Override
            public void onClick(View view, int position) {

            }
        });*/
    }

}
