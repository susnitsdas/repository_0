package com.example.lasttask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class SignUp extends AppCompatActivity {

    TextInputLayout regEmail, regPassword;
    Button regBtn, regToLoginBtn;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        regEmail = findViewById(R.id.reg_email);
        regPassword = findViewById(R.id.reg_password);
        regBtn = findViewById(R.id.regBtn);
        regToLoginBtn = findViewById(R.id.regToLoginBtn);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        regToLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void registerUser(){

        String email = regEmail.getEditText().getText().toString().trim();
        String password = regPassword.getEditText().getText().toString().trim();

        if (email.isEmpty())
        {
           regEmail.setError("Email is required");
           regEmail.requestFocus();
           return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
           regEmail.setError("Please enter a valid email");
           regEmail.requestFocus();
           return;
        }

        if (password.isEmpty())
        {
            regPassword.setError("Password is required");
            regPassword.requestFocus();
            return;
        }

        if (password.length()<6)
        {
            regPassword.setError("Minimum length of password should be 6");
            regPassword.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Intent intent = new Intent(SignUp.this, Dashboard.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else
                    {
                        Toast.makeText(getApplicationContext(), "Some error occured", Toast.LENGTH_SHORT).show();
                    }

            }
        });

    }
}
