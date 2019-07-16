package com.example.attendencecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FutureDate extends AppCompatActivity {

    private EditText CA, CD, DLI, DLN, ML;
    private EditText mondayca,mondaycd;
    private EditText tuesdayca,tuesdaycd;
    private EditText wednesdayca,wednesdaycd;
    private EditText thursdayca,thursdaycd;
    private EditText fridayca,fridaycd;
    private Button proceedbtn,continuebtn,proceed2btn;
    private Button reset1btn,reset2btn,moredetailsbtn;
    private TextView physicalattendencetextview, totalattendencetextview,aftertotalattendencetextview,afterphysicalattendencetextview;
    private TextView mondaytextview,tuesdaytextview,wednesdaytextview,thursdaytextview,fridaytextview;
    private TextView resulttextview;
    private float physicalattendence, totalattendence, sumofCADLI, includingDLIattendence,afterincludingDLIattendence,aftersumofCADLI;
    private float afterCA,afterCD,afterattended,afterCADLI,afterphysicalattendence,aftertotalattendence,aftercasum,aftercdsum;
    private int Sum,class_Delivered,afterclass_Delivered1,afterSum1;
    private String CAString,CDString,DLIString,DLNString,MLString;
    private float numberofdays=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future_date);
        CA = (EditText) findViewById(R.id.ClassAttendedTextField);
        CD = (EditText) findViewById(R.id.ClassdDliveredTextField);
        DLI = (EditText) findViewById(R.id.DLIncludedTextField);
        DLN = (EditText) findViewById(R.id.DLNotIncludedTextField);
        ML = (EditText) findViewById(R.id.MedicalLeaveTextField);
        proceedbtn = (Button) findViewById(R.id.TapToProceedButton);
        continuebtn= (Button)findViewById(R.id.TapToContinueButton) ;
        reset1btn=(Button)findViewById(R.id.Reset1Button);
        physicalattendencetextview = (TextView) findViewById(R.id.PhysicalAttendenceTextView);
        totalattendencetextview = (TextView) findViewById(R.id.TotalAttendenceTextView);
        mondayca=(EditText) findViewById(R.id.MondayClassAttendedTextField);
        mondaycd=(EditText) findViewById(R.id.MondayClassDeliveredTextField);
        mondaytextview=(TextView) findViewById(R.id.MondayTextView);
        tuesdayca=(EditText) findViewById(R.id.TuesdayClassAttendedTextField);
        tuesdaycd=(EditText) findViewById(R.id.TuesdayClassDeliveredTextField);
        tuesdaytextview=(TextView) findViewById(R.id.TuesdayTextView);
        wednesdayca=(EditText) findViewById(R.id.WednesdayClassAttendedTextField);
        wednesdaycd=(EditText) findViewById(R.id.WednesdayClassDeliveredTextField);
        wednesdaytextview=(TextView) findViewById(R.id.WednesdayTextView);
        thursdayca=(EditText) findViewById(R.id.ThursdayClassAttendedTextField);
        thursdaycd=(EditText) findViewById(R.id.ThursdayClassDeliveredTextField);
        thursdaytextview=(TextView) findViewById(R.id.ThursdayTextView);
        fridayca=(EditText) findViewById(R.id.FridayClassAttendedTextField);
        fridaycd=(EditText) findViewById(R.id.FridayClassDeliveredTextField);
        fridaytextview=(TextView) findViewById(R.id.FridayTextView);
        proceed2btn=(Button)findViewById(R.id.TapToProceed2Button);
        reset2btn=(Button)findViewById(R.id.Reset2Button);
        afterphysicalattendencetextview=(TextView)findViewById(R.id.AfterPhysicalAttendenceTextView);
        aftertotalattendencetextview=(TextView)findViewById(R.id.AfterTotalAttendenceTextView);




        hide();
        proceedbtn.setOnClickListener(new View.OnClickListener() {
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
                        getPercentage();
                        physicalattendencetextview.setText("Physical Attendence = "+Float.toString(physicalattendence)+"%");
                        totalattendencetextview.setText("Total Attendence = "+Float.toString(totalattendence)+"%");
                        continuebtn.setVisibility(View.VISIBLE);

                    }}}
        });

        reset1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CA.setText("");
                CD.setText("");
                DLI.setText("");
                DLN.setText("");
                ML.setText("");
                physicalattendencetextview.setText("");
                totalattendencetextview.setText("");
                hide();
            }
        });

        continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mondaytextview.setVisibility(View.VISIBLE);
                mondaycd.setVisibility(View.VISIBLE);
                mondayca.setVisibility(View.VISIBLE);
                tuesdayca.setVisibility(View.VISIBLE);
                tuesdaycd.setVisibility(View.VISIBLE);
                tuesdaytextview.setVisibility(View.VISIBLE);
                wednesdayca.setVisibility(View.VISIBLE);
                wednesdaycd.setVisibility(View.VISIBLE);
                wednesdaytextview.setVisibility(View.VISIBLE);
                thursdayca.setVisibility(View.VISIBLE);
                thursdaycd.setVisibility(View.VISIBLE);
                thursdaytextview.setVisibility(View.VISIBLE);
                fridayca.setVisibility(View.VISIBLE);
                fridaycd.setVisibility(View.VISIBLE);
                fridaytextview.setVisibility(View.VISIBLE);
                proceed2btn.setVisibility(View.VISIBLE);
                reset2btn.setVisibility(View.VISIBLE);
                afterphysicalattendencetextview.setVisibility(View.VISIBLE);
                aftertotalattendencetextview.setVisibility(View.VISIBLE);

            }
        });


        proceed2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mondaycastring=mondayca.getText().toString();
                String mondaycdstring=mondaycd.getText().toString();
                String tuesdaycastring=tuesdayca.getText().toString();
                String tuesdaycdstring=tuesdaycd.getText().toString();
                String wednesdaycastring=wednesdayca.getText().toString();
                String wednesdaycdstring=wednesdaycd.getText().toString();
                String thursdaycastring=thursdayca.getText().toString();
                String thursdaycdstring=thursdaycd.getText().toString();
                String frisdaycastring=fridayca.getText().toString();
                String fridaycdstring=fridaycd.getText().toString();
                if (mondaycastring.isEmpty()||mondaycdstring.isEmpty()||tuesdaycastring.isEmpty()||tuesdaycdstring.isEmpty()||wednesdaycastring.isEmpty()||wednesdaycdstring.isEmpty()||thursdaycastring.isEmpty()||thursdaycdstring.isEmpty()||fridaycdstring.isEmpty()||frisdaycastring.isEmpty())
                {
                    afterphysicalattendencetextview.setText("Enter the values!! Field(s) are empty");
                    aftertotalattendencetextview.setText("");

                }else{

                    afterSum1= Integer.valueOf(CA.getText().toString())+Integer.valueOf(DLI.getText().toString())+Integer.valueOf(DLN.getText().toString())+Integer.valueOf(ML.getText().toString())+Integer.valueOf(mondayca.getText().toString())+Integer.valueOf(tuesdayca.getText().toString())+Integer.valueOf(wednesdayca.getText().toString())+Integer.valueOf(thursdayca.getText().toString())+Integer.valueOf(fridayca.getText().toString());
                    afterclass_Delivered1=Integer.valueOf(CD.getText().toString())+Integer.valueOf(mondaycd.getText().toString())+Integer.valueOf(tuesdaycd.getText().toString())+Integer.valueOf(wednesdaycd.getText().toString())+Integer.valueOf(thursdaycd.getText().toString())+Integer.valueOf(fridaycd.getText().toString());
                    if(afterSum1>afterclass_Delivered1) {
                        afterphysicalattendencetextview.setText("Invalid Input(s). Enter Valid Input(s) and Try Again!!!!");
                        aftertotalattendencetextview.setText(" ");
                    }else{
                        getinfopercentage();
                        getafterpercentage();
                        afterphysicalattendencetextview.setText("After attendeing "+Integer.toString(Math.round(afterCA))+" class out of "+Integer.toString(Math.round(afterCD))+" class");
                        aftertotalattendencetextview.setText(" Physical Attendence ="+Float.toString(afterphysicalattendence)+"%"+"\n"+"Total Attendence = "+Float.toString(aftertotalattendence)+"%");

                    }}


            }
        });

        reset2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mondaycd.setText("");
                mondayca.setText("");
                tuesdaycd.setText("");
                tuesdayca.setText("");
                wednesdaycd.setText("");
                wednesdayca.setText("");
                thursdaycd.setText("");
                thursdayca.setText("");
                fridaycd.setText("");
                fridayca.setText("");
                afterphysicalattendencetextview.setText("");
                aftertotalattendencetextview.setText("");


            }
        });




    }

    public void getPercentage() {
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
    public void hide(){
        continuebtn.setVisibility(View.INVISIBLE);
        mondaytextview.setVisibility(View.INVISIBLE);
        mondaycd.setVisibility(View.INVISIBLE);
        mondayca.setVisibility(View.INVISIBLE);
        tuesdayca.setVisibility(View.INVISIBLE);
        tuesdaycd.setVisibility(View.INVISIBLE);
        tuesdaytextview.setVisibility(View.INVISIBLE);
        wednesdayca.setVisibility(View.INVISIBLE);
        wednesdaycd.setVisibility(View.INVISIBLE);
        wednesdaytextview.setVisibility(View.INVISIBLE);
        thursdayca.setVisibility(View.INVISIBLE);
        thursdaycd.setVisibility(View.INVISIBLE);
        thursdaytextview.setVisibility(View.INVISIBLE);
        fridayca.setVisibility(View.INVISIBLE);
        fridaycd.setVisibility(View.INVISIBLE);
        fridaytextview.setVisibility(View.INVISIBLE);
        proceed2btn.setVisibility(View.INVISIBLE);
        reset2btn.setVisibility(View.INVISIBLE);
        afterphysicalattendencetextview.setVisibility(View.INVISIBLE);
        aftertotalattendencetextview.setVisibility(View.INVISIBLE);



    }

    public void getinfopercentage() {
        afterCA = Float.valueOf(mondayca.getText().toString()) + Float.valueOf(tuesdayca.getText().toString()) + Float.valueOf(wednesdayca.getText().toString()) + Float.valueOf(thursdayca.getText().toString()) + Float.valueOf(fridayca.getText().toString());
        afterCD = Float.valueOf(mondaycd.getText().toString()) + Float.valueOf(tuesdaycd.getText().toString()) + Float.valueOf(wednesdaycd.getText().toString()) + Float.valueOf(thursdaycd.getText().toString()) + Float.valueOf(fridaycd.getText().toString());
        aftercasum = afterCA + Float.valueOf(CA.getText().toString());
        aftercdsum = afterCD + Float.valueOf(CD.getText().toString());
        aftersumofCADLI = aftercasum + Float.valueOf(DLI.getText().toString());
        afterincludingDLIattendence = (aftersumofCADLI / Float.valueOf(aftercdsum)) * 100;
        afterphysicalattendence = (aftercasum / aftercdsum) * 100;

    }
     public void getafterpercentage(){
        if (afterincludingDLIattendence >= 65.0)
            aftersumofCADLI = aftersumofCADLI + Float.valueOf(DLN.getText().toString()) + Float.valueOf(ML.getText().toString());
        else
            {
                aftersumofCADLI = aftercasum+Float.valueOf(DLI.getText().toString());
            }
            aftertotalattendence = aftersumofCADLI / aftercdsum * 100;

        }



    }
