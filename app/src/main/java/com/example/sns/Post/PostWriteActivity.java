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

    SetData setData = new SetData();
    GetData getData = new GetData() ;
    ArrayList<Subject> subjects = new ArrayList<Subject>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);

        Intent intent = getIntent() ;
        final String subject = intent.getExtras().getString("subject") ;
        final int[] index = new int[1];

        Button button = (Button) findViewById(R.id.button) ;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent intent = new Intent(PostWriteActivity.this, PostViewActivity.class) ;
                EditText editText1 = (EditText)findViewById(R.id.editText3) ;
                //intent.putExtra("contact_writer", editText1.getText().toString()) ;

                EditText editText = (EditText)findViewById(R.id.editText) ;
                //intent.putExtra("contact_title", editText.getText().toString()) ;

                EditText editText2 = (EditText)findViewById(R.id.editText2) ;
                //intent.putExtra("contact_content", editText2.getText().toString());

                getData.resultSubject(subjects);
                for(int i = 0 ; i<subjects.size();i++){
                    if(subjects.get(i).getSubject_name().equals(subject)){
                        setData.writePost(subject, userID ,editText.getText().toString(), editText2.getText().toString()) ;
                    }
                }
                //startActivity(intent);
            }
        });
    }
}