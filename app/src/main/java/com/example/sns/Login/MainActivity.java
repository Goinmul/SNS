package com.example.sns.Login;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sns.R;
import com.example.sns.SubjectList.TabActivity;

public class MainActivity extends AppCompatActivity {
    EditText idText ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idText = (EditText) findViewById(R.id.idText);
        EditText passwordText = (EditText) findViewById(R.id.passwordText);
        Button loginButton = (Button) findViewById(R.id.loginButton);
        TextView registerButton = (TextView) findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent registerintent = new Intent(MainActivity.this, RegisterActivity.class);
                MainActivity.this.startActivity(registerintent);
            }
        });
    }

    public void logIn_click(View view) {

        Intent login_intent = new Intent(this, TabActivity.class);
        login_intent.putExtra("userID", idText.getText().toString());
        MainActivity.this.startActivity(login_intent);

    }
}
