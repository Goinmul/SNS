package com.example.sns;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sns.DB.GetData;
import com.example.sns.Model.User;

import java.util.ArrayList;

public class UserInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        TextView textId = (TextView) findViewById(R.id.user_id) ;
        TextView textName = (TextView) findViewById(R.id.user_name) ;
        TextView textNum = (TextView) findViewById(R.id.user_num) ;

        String user_id = "samuel1226";

        GetData getdata = new GetData();

        ArrayList<User> user = new ArrayList<User>();

        getdata.resultUser(user);

        for (int i = 0; i < user.size(); i++) {
            if (user_id.equals(user.get(i).getUser_id())){
                textId.setText(user.get(i).getUser_id());
                textName.setText(user.get(i).getUser_name());
                textNum.setText(""+user.get(i).getUser_num());
            }
        }

    }
}
