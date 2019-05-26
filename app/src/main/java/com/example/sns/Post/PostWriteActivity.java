package com.example.sns.Post;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sns.DB.GetData;
import com.example.sns.DB.SetData;
import com.example.sns.Model.Subject;
import com.example.sns.R;

import java.util.ArrayList;

public class PostWriteActivity extends AppCompatActivity {
    static String userID = "hn1226 " ;
    static int edit ;
    SetData setData = new SetData();
    GetData getData = new GetData() ;
    ArrayList<Subject> subjects = new ArrayList<Subject>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);

        final Intent intent = getIntent() ;
        final Intent editIntent = getIntent() ;
        final String subject = intent.getExtras().getString("subject") ;
        final EditText editText = (EditText)findViewById(R.id.editText) ;
        final EditText editText2 = (EditText)findViewById(R.id.editText2) ;
        String editUserID ;
        String editTitle ;
        String editContent ;
        Button button = (Button) findViewById(R.id.button) ;
        edit = 0 ;
        edit = editIntent.getExtras().getInt("editPostID") ;
        if(edit!=0){
            int editPostID = editIntent.getExtras().getInt("editPostID") ;
            editUserID = editIntent.getExtras().getString("editUserID") ;
            editTitle = editIntent.getExtras().getString("editTitle") ;
            editContent = editIntent.getExtras().getString("editContent") ;
            editText.setText(editTitle) ;
            editText2.setText(editContent);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PostWriteActivity.this, PostViewActivity.class) ;
                intent.putExtra("title", editText.getText().toString()) ;
                intent.putExtra("id",userID) ;
                intent.putExtra("subject", subject) ;
                if(edit!=0){
                    setData.editPost(subject, editText.getText().toString(),editText2.getText().toString(),edit);
                }
                else{
                    if(editText.getText().toString()!=null && editText2.getText().toString()!=null){
                        getData.resultSubject(subjects);
                        for(int i = 0 ; i<subjects.size();i++){
                            if(subjects.get(i).getSubject_name().equals(subject)){
                                setData.writePost(subject, userID ,editText.getText().toString(), editText2.getText().toString()) ;
                            }
                        }
                    }
                }
                startActivity(intent);
            }
        });
    }
}