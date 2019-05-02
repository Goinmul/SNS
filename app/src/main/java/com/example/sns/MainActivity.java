package com.example.sns;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text = (TextView)findViewById(R.id.text);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String test = "http://samuel1226.dothome.co.kr/project/data.php";
        URLConnector task = new URLConnector(test);

        task.start();

        try{
            task.join();
            System.out.println("waiting... for result");
        }
        catch(InterruptedException e){

        }

        String result = task.getResult();

        text.append(result);

        System.out.println(result);
    }
}
