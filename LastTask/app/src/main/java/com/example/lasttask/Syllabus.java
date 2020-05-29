package com.example.lasttask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Syllabus extends AppCompatActivity {

    Button archi, biotech, civil, cse, electrical, fat, it, ie, mechanical, textile, planning, maths, phy, chem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);


        civil = findViewById(R.id.civil);
        cse = findViewById(R.id.cse);
        electrical = findViewById(R.id.electrical);
        fat = findViewById(R.id.fat);
        it = findViewById(R.id.it);
        ie = findViewById(R.id.ie);
        mechanical = findViewById(R.id.mechanical);
        textile = findViewById(R.id.textile);



    }


}


