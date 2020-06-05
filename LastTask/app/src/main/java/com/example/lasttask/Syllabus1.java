package com.example.lasttask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Syllabus1 extends AppCompatActivity {

    TextView tv_Syllabus;
    Spinner sp_branch, sp_sem;

    ArrayList<String> arrayList_branch;
    ArrayAdapter<String> arrayAdapter_branch;

    ArrayList<String> arrayList_sem;
    ArrayAdapter<String> arrayAdapter_sem;
    String syllabus;

    int branch = 0, sem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus1);

        tv_Syllabus = findViewById(R.id.tv_syllabus);
        tv_Syllabus.setVisibility(View.GONE);

        sp_branch = findViewById(R.id.sp_branch);
        sp_sem = findViewById(R.id.sp_sem);

        arrayList_branch = new ArrayList<>();
        //arrayList_branch.add("Architecture");
        //arrayList_branch.add("Biotechnology");
        //arrayList_branch.add("Civil Engineering");
        //arrayList_branch.add("Computer Science Engineering");
        //arrayList_branch.add("Electrical Engineering");
        //arrayList_branch.add("Fashion and Appeal Engineering");
        //arrayList_branch.add("Information Technology Engineering");
        arrayList_branch.add("Instrumentation and Electronics Engineering");
        //arrayList_branch.add("Mechanical Engineering");
        //arrayList_branch.add("Textile Engineering");
        //arrayList_branch.add("Planning");

        arrayAdapter_branch = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, arrayList_branch);

        sp_branch.setAdapter(arrayAdapter_branch);

        arrayList_sem = new ArrayList<>();
        arrayList_sem.add("1st Semester");
        arrayList_sem.add("2nd Semester");
        arrayList_sem.add("3rd Semester");
        arrayList_sem.add("4th Semester");
        arrayList_sem.add("5th Semester");
        arrayList_sem.add("6th Semester");
        arrayList_sem.add("7th Semester");
        arrayList_sem.add("8th Semester");

        arrayAdapter_sem = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, arrayList_sem);

        sp_sem.setAdapter(arrayAdapter_sem);

        sp_branch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position)
                {
                    case 0:
                        branch = 1;


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sp_sem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



                switch (position)
                {
                    case 0:
                        sem = 1;

                    case 1:
                        sem = 2;

                    case 2:
                        sem = 3;

                    case 3:
                        sem = 4;

                    case 4:
                        sem = 5;

                    case 5:
                        sem = 6;

                    case 6:
                        sem = 7;

                    case 7:
                        sem = 8;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if((branch == 1) && (sem == 0))
        {
            tv_Syllabus.setVisibility(View.VISIBLE);
            syllabus = "IE 1st semester syllabus";
            tv_Syllabus.setText(syllabus);
        }
        else if((branch == 1) && (sem == 1))
        {
            tv_Syllabus.setVisibility(View.VISIBLE);
            syllabus = "IE 2nd semester syllabus";
            tv_Syllabus.setText(syllabus);
        }
        else if((branch == 1) && (sem == 3))
        {
            tv_Syllabus.setVisibility(View.VISIBLE);
            syllabus = "IE 3rd semester syllabus";
            tv_Syllabus.setText(syllabus);
        }
        else if((branch == 1) && (sem == 4))
        {
            tv_Syllabus.setVisibility(View.VISIBLE);
            syllabus = "IE 4th semester syllabus";
            tv_Syllabus.setText(syllabus);
        }
        else if((branch == 1) && (sem == 5))
        {
            tv_Syllabus.setVisibility(View.VISIBLE);
            syllabus = "IE 5th semester syllabus";
            tv_Syllabus.setText(syllabus);
        }
        else if((branch == 1) && (sem == 6))
        {
            tv_Syllabus.setVisibility(View.VISIBLE);
            syllabus = "IE 6th semester syllabus";
            tv_Syllabus.setText(syllabus);
        }
        else if((branch == 1) && (sem == 7))
        {
            tv_Syllabus.setVisibility(View.VISIBLE);
            syllabus = "IE 7st semester syllabus";
            tv_Syllabus.setText(syllabus);
        }
        else
        {
            tv_Syllabus.setVisibility(View.VISIBLE);
            syllabus = "IE 8th semester syllabus";
            tv_Syllabus.setText(syllabus);
        }










    }




}
