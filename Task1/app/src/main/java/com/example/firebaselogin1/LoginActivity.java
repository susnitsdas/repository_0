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
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    EditText etEmail, etPassword;
    Button btnSignin;
    TextView tvSignup;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignin = findViewById(R.id.button);
        tvSignup = findViewById(R.id.textView);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (mFirebaseUser!=null)
                {
                    Toast.makeText(LoginActivity.this, "You are logged in", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Please login", Toast.LENGTH_SHORT).show();
                }
            }
        };

        btnSignin.setOnClickListener(new View.OnClickListener() {
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
                    Toast.makeText(LoginActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else if (!(email.isEmpty() && password.isEmpty()))
                {
                    mFirebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful())
                            {
                                Toast.makeText(LoginActivity.this, "Login error, Please try again", Toast.LENGTH_SHORT).show();

                            }
                            else
                            {
                                Intent intToHome = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(intToHome);
                            }

                        }
                    });
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Error Occurred", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intSignup = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intSignup);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}
