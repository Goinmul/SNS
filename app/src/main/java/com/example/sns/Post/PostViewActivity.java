package com.example.sns.Post;

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

import com.example.sns.Comment.Comment;
import com.example.sns.DB.GetData;
import com.example.sns.Model.Post;
import com.example.sns.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PostViewActivity extends AppCompatActivity {
    private ArrayList<Comment> mArrayList;
    private CustomAdapter2 mAdapter;
    private RecyclerView mRecyclerView;
    static String postuserID  ;
    static String viewuserID = "samuel1226";
    static String posttitle ;
    GetData getdata = new GetData();
    ArrayList<Post> post = new ArrayList<Post>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postview);

        Intent getintent = getIntent() ;
        postuserID = getintent.getExtras().getString("id") ;
        posttitle = getintent.getExtras().getString("title") ;
        String subject = getintent.getExtras().getString("subject") ;
        String postcontent = null;

        TextView writer = (TextView) findViewById(R.id.editText7) ;
         writer.setText(postuserID) ;

        TextView title = (TextView) findViewById(R.id.editText6) ;
        title.setText(posttitle) ;
        getdata.resultPost(post);
        for(int i = 0 ; i<post.size(); i++) {
            if(post.get(i).getSubject_name().equalsIgnoreCase(subject)&&
                    post.get(i).getUser_id().equalsIgnoreCase(postuserID)&&
            post.get(i).getTitle().equalsIgnoreCase(posttitle)) {
                postcontent = post.get(i).getContent() ;
            }
        }

        TextView content = (TextView) findViewById(R.id.post_contents_text) ;
        content.setText(postcontent);

        final TextView TextName = (TextView) findViewById(R.id.editText5) ;
        TextName.setText(viewuserID) ;
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
                String strName = TextName.getText().toString();
                String strContents = editTextContents.getText().toString() ;

                Comment com = new Comment(strName, strContents) ;

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
