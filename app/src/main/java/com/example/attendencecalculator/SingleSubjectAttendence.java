package com.example.attendencecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SingleSubjectAttendence extends AppCompatActivity {

    private EditText CA, CD, DLI, DLN, ML;
    private Button Calculate,Reset;
    private TextView physicalattendencetextview, totalattendencetextview;
    private float physicalattendence, totalattendence, sumofCADLI, includingDLIattendence;
    private int Sum,class_Delivered;
    private String CAString,CDString,DLIString,DLNString,MLString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_subject_attendence);

        CA = (EditText) findViewById(R.id.classattendedTextField);
        CD = (EditText) findViewById(R.id.classdeliveredTextField);
        DLI = (EditText) findViewById(R.id.dlincludedTextField);
        DLN = (EditText) findViewById(R.id.dlnotincludedTextField);
        ML = (EditText) findViewById(R.id.medicalleaveTextfield);
        Calculate = (Button) findViewById(R.id.calculateButton);
        Reset=(Button)findViewById(R.id.ResetButton);
        physicalattendencetextview = (TextView) findViewById(R.id.physicalattendenceTextView);
        totalattendencetextview = (TextView) findViewById(R.id.totalattendenceTextView);




        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CAString=CA.getText().toString();
                CDString=CD.getText().toString();
                DLIString=DLI.getText().toString();
                DLNString=DLN.getText().toString();
                MLString=ML.getText().toString();
                if(CAString.isEmpty()|| CDString.isEmpty()||DLIString.isEmpty()||DLNString.isEmpty()||MLString.isEmpty())
                {
                    physicalattendencetextview.setText("Enter the values!! Field(s) are empty");
                    totalattendencetextview.setText("");
                }else {
                Sum= Integer.valueOf(CA.getText().toString())+Integer.valueOf(DLI.getText().toString())+Integer.valueOf(DLN.getText().toString())+Integer.valueOf(ML.getText().toString());
                class_Delivered=Integer.valueOf(CD.getText().toString());
                if(Sum>class_Delivered) {
                physicalattendencetextview.setText("Invalid Input(s). Enter Valid Input(s) and Try Again!!!!");
                totalattendencetextview.setText(" ");
                }
                else{
                getPercentage(CA, CD, DLI, DLN, ML);
                physicalattendencetextview.setText("Physical Attendence = "+Float.toString(physicalattendence));
                totalattendencetextview.setText("Total Attendence = "+Float.toString(totalattendence));
            }}}
        });

       Reset.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               CA.setText("");
               CD.setText("");
               DLI.setText("");
               DLN.setText("");
               ML.setText("");
               physicalattendencetextview.setText("");
               totalattendencetextview.setText("");

           }
       });

    }

    public void getPercentage(EditText attendedClass, EditText deliveredClass, EditText IncludingDL, EditText Notincludingdl, EditText medicalLeave) {
        physicalattendence = (Float.valueOf(CA.getText().toString()) / Float.valueOf(CD.getText().toString())) * 100;
        sumofCADLI = Float.valueOf(CA.getText().toString()) + Float.valueOf(DLI.getText().toString());
        includingDLIattendence = (sumofCADLI / Float.valueOf(CD.getText().toString())) * 100;
        if (includingDLIattendence >= 65.0) {
            sumofCADLI = Float.valueOf(CA.getText().toString()) + Float.valueOf(DLI.getText().toString()) + Float.valueOf(DLN.getText().toString()) + Float.valueOf(ML.getText().toString());

        } else {
            sumofCADLI = Float.valueOf(CA.getText().toString()) + Float.valueOf(DLI.getText().toString());

        }
        totalattendence = sumofCADLI / Float.valueOf(CD.getText().toString()) * 100;
    }
}