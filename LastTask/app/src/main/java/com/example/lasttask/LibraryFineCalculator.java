package com.example.lasttask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LibraryFineCalculator extends AppCompatActivity {

    Button button;
    TextView tvFine;
    EditText etDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_fine_calculator);

        button = findViewById(R.id.button);
        etDays = findViewById(R.id.etDays);
        tvFine = findViewById(R.id.tvFine);

        tvFine.setVisibility(View.GONE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etDays.getText().toString().isEmpty())
                {
                    Toast.makeText(LibraryFineCalculator.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int days = Integer.parseInt(etDays.getText().toString().trim());

                    double fine = days*2;

                    String results = "Your fine is Rs." + fine;

                    tvFine.setText(results);
                    tvFine.setVisibility(View.VISIBLE);
                }

            }
        });
    }
}
