package com.example.firebaselogin1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnSignup;
    TextView tvSignin;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth = FirebaseAuth.getInstance();
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignup = findViewById(R.id.button);
        tvSignin = findViewById(R.id.textView);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                if(email.isEmpty())
                {
                    etEmail.setError("please enter your email id");
                    etEmail.requestFocus();
                }
                else if(password.isEmpty())
                {
                    etPassword.setError("Please enter your password");
                    etPassword.requestFocus();
                }
                else if(email.isEmpty() && password.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Fields are empty", Toast.LENGTH_SHORT);
                }
                else if (!(email.isEmpty() && password.isEmpty()))
                {
                    mFirebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener
                            (MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                          if (!(task.isSuccessful()))
                          {
                              Toast.makeText(MainActivity.this, "SignUp unsuccessful, please try again", Toast.LENGTH_SHORT);
                          }
                          else
                          {
                              startActivity(new Intent(MainActivity.this, HomeActivity.class));
                          }
                        }
                    });
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Error Occurred", Toast.LENGTH_SHORT);
                }
            }
        });

        tvSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
}

