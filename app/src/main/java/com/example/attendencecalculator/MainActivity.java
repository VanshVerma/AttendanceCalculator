package com.example.attendencecalculator;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button Singlebtn,Futuredatebtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Singlebtn=(Button)findViewById(R.id.singlesubjectButton);
        Futuredatebtn=(Button)findViewById(R.id.futuredateButton);


        Singlebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,SingleSubjectAttendence.class);
                startActivity(intent1);
            }
        });

        Futuredatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this,FutureDate.class);
                        startActivity(intent2);
            }
        });


    }
}
