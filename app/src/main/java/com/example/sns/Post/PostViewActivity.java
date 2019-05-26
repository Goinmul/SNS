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

import com.example.sns.Comment.CommentActivity;
import com.example.sns.Comment.CommentList;
import com.example.sns.DB.GetData;
import com.example.sns.DB.SetData;
import com.example.sns.Model.Comment;
import com.example.sns.Model.Post;
import com.example.sns.R;
import com.example.sns.SubjectList.TabActivity;

import java.util.ArrayList;

public class PostViewActivity extends AppCompatActivity {
    private ArrayList<CommentList> mArrayList;
    private CustomAdapter2 mAdapter;
    private RecyclerView mRecyclerView;
    static String postuserID  ;
    static String viewuserID = "ha";
    static String posttitle ;
    static String postcontent ;
    static int postID ;
    static float pointsum;
    static int pointcount;

    SetData setData = new SetData();
    GetData getData = new GetData() ;
    ArrayList<Post> post = new ArrayList<Post>();
    ArrayList<Comment> dbcomment = new ArrayList<Comment>() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postview);

        final ArrayList<Float> point = new ArrayList<Float>() ;
        pointsum=0 ;
        pointcount=0 ;
        final Intent getintent = getIntent() ;
        postuserID = getintent.getExtras().getString("id") ;
        posttitle = getintent.getExtras().getString("title") ;
        final String subject = getintent.getExtras().getString("subject") ;


        TextView writer = (TextView) findViewById(R.id.editText7) ;
         writer.setText(postuserID) ;

        TextView title = (TextView) findViewById(R.id.editText6) ;
        title.setText(posttitle) ;
        getData.resultPost(post);
        getData.resultComment(dbcomment) ;
        for(int i = 0 ; i<post.size(); i++) {
            if(post.get(i).getSubject_name().equalsIgnoreCase(subject)&&
                    post.get(i).getUser_id().equalsIgnoreCase(postuserID)&&
                    post.get(i).getTitle().equalsIgnoreCase(posttitle)) {
                postcontent = post.get(i).getContent() ;
                postID = post.get(i).getIndex() ;
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
        Button buttonedit = (Button)findViewById(R.id.editPost);
        Button buttondelete = (Button)findViewById(R.id.deletePost);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strName = TextName.getText().toString();
                String strContents = editTextContents.getText().toString() ;
                setData.writeComment(postID, viewuserID, strContents);
                CommentList com = new CommentList(viewuserID,strContents) ;
                mArrayList.add(com) ;
                mAdapter.notifyDataSetChanged() ;

            }
        });
        for(int i = 0 ; i<dbcomment.size();i++){
            if(dbcomment.get(i).getPost_index()==postID) {
                CommentList com = new CommentList(dbcomment.get(i).getUser_id(), dbcomment.get(i).getContent());
                mArrayList.add(com);
                mAdapter.notifyDataSetChanged();
            }
        }
        buttonIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PostViewActivity.this, PostListActivity.class) ;
                intent.putExtra("clicked_subject_name", subject) ;
                startActivity(intent) ;
            }
        });
        buttonedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(postuserID==viewuserID){
                    Intent editintent = new Intent(PostViewActivity.this, PostWriteActivity.class) ;
                    editintent.putExtra("editPostID", postID) ;
                    editintent.putExtra("editUserID", postuserID) ;
                    editintent.putExtra("editTitle", posttitle) ;
                    editintent.putExtra("editContent", postcontent) ;
                    startActivity(editintent) ;
                }
                else {
                    Toast.makeText(PostViewActivity.this, "권한 없음", Toast.LENGTH_SHORT).show();
                }

            }
        });
        buttondelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(postuserID==viewuserID) {
                    Intent deleteintent = new Intent(PostViewActivity.this, PostListActivity.class) ;
                    setData.deletePost(postID);
                    deleteintent.putExtra("clicked_subject_name", subject) ;
                    Toast.makeText(PostViewActivity.this, "삭제되었습니다.", Toast.LENGTH_SHORT).show();
                    startActivity(deleteintent) ;
                }
                else {
                    Toast.makeText(PostViewActivity.this, "권한 없음", Toast.LENGTH_SHORT).show();
                }
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


                        //point.add(Float.parseFloat(items[selectedItem[0]])) ;
                        //pointsum +=point.get(pointcount) ;
                        pointcount++ ;
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
