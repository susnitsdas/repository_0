package com.example.lasttask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    Button callSignUp, btnGo;
    ImageView logo_image;
    TextView logo_text, slogan_text;
    TextInputLayout reg_email, reg_password;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        callSignUp = findViewById(R.id.signup_screen);
        btnGo = findViewById(R.id.btnGo);
        logo_image = findViewById(R.id.logo_image);
        logo_text = findViewById(R.id.logo_name);
        slogan_text = findViewById(R.id.slogan_name);
        reg_email = findViewById(R.id.email);
        reg_password = findViewById(R.id.password);

        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, SignUp.class);
                Pair[] pairs = new Pair[7];
                pairs[0] = new Pair<View, String>(logo_image, "logo_image");
                pairs[1] = new Pair<View, String>(logo_text, "logo_Text");
                pairs[2] = new Pair<View, String>(slogan_text, "logo_desc");
                pairs[3] = new Pair<View, String>(reg_email, "username_tran");
                pairs[4] = new Pair<View, String>(reg_password, "password_tran");
                pairs[5] = new Pair<View, String>(btnGo, "btn_tran");
                pairs[6] = new Pair<View, String>(callSignUp, "login_signup_tran");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs);
                    startActivity(intent, options.toBundle());
                }

            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });
    }
    private void userLogin()
    {
        String email = reg_email.getEditText().getText().toString().trim();
        String password = reg_password.getEditText().getText().toString().trim();

        if (email.isEmpty())
        {
            reg_email.setError("Email is required");
            reg_email.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            reg_email.setError("Please enter a valid email");
            reg_email.requestFocus();
            return;
        }

        if (password.isEmpty())
        {
            reg_password.setError("Password is required");
            reg_password.requestFocus();
            return;
        }

        if (password.length()<6)
        {
            reg_password.setError("Minimum length of password should be 6");
            reg_password.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                   Intent intent = new Intent(LoginActivity.this, Dashboard.class);
                   intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                   startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();;
                }
            }
        });
    }
}
