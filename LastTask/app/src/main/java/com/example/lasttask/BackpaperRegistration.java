package com.example.lasttask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BackpaperRegistration extends AppCompatActivity {

    EditText etName, etBranch, etRegd, etSub, etSubcode;
    TextView tvName, tvBranch, tvRegd, tvSub, tvSubCode;
    Button btnSubmit, btnFetch;
    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backpaper_registration);

        etName = findViewById(R.id.etName);
        etBranch = findViewById(R.id.etBranch);
        etRegd = findViewById(R.id.etRegd);
        etSub = findViewById(R.id.etSub);
        etSubcode = findViewById(R.id.etSubCode);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvName = findViewById(R.id.tvName);
        tvBranch = findViewById(R.id.tvBranch);
        tvRegd = findViewById(R.id.tvRegd);
        tvSub = findViewById(R.id.tvSub);
        tvSubCode = findViewById(R.id.tvSubCode);
        btnFetch = findViewById(R.id.btnFetch);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("user");

                String name = etName.getText().toString();
                String branch = etBranch.getText().toString();
                String regdNo = etRegd.getText().toString();
                String sub = etSub.getText().toString();
                String subCode = etSubcode.getText().toString();

                UserHelperClass helperClass = new UserHelperClass(name, branch, regdNo, sub, subCode);

                reference.child(regdNo).setValue(helperClass);
            }
        });

        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String regdNo = etRegd.getText().toString();
                reference = FirebaseDatabase.getInstance().getReference().child("user").child(regdNo);
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String name = dataSnapshot.child("name").getValue(String.class);
                        String branch = dataSnapshot.child("branch").getValue(String.class);
                        String sub = dataSnapshot.child("sub").getValue(String.class);
                        String regdno = dataSnapshot.child("regdNo").getValue(String.class);
                        String subCode = dataSnapshot.child("subCode").getValue(String.class);

                        tvName.setText(name);
                        tvBranch.setText(branch);
                        tvRegd.setText(regdno);
                        tvSub.setText(sub);
                        tvSubCode.setText(subCode);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                        Toast.makeText(BackpaperRegistration.this, "Error fetching data", Toast.LENGTH_LONG).show();

                    }
                });
            }
        });

    }
}
