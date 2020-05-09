package com.example.task0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etRegd;
    Button btn;
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etRegd = findViewById(R.id.etRegd);
        btn = findViewById(R.id.btn);
        tvName = findViewById(R.id.tvName);

        tvName.setVisibility(View.GONE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etRegd.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "please enter your regd number", Toast.LENGTH_SHORT).show();
                }
                else if(etRegd.getText().toString().trim().equals("1801106583"))
                {
                    tvName.setVisibility(View.VISIBLE);
                    tvName.setText("Susnita Das");
                }
                else
                {
                    tvName.setText("please enter a valid regd number");
                }
            }
        });
    }
}
