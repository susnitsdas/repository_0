package com.example.firebaselogin1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    Button btnMessage, btnCall, btnInstagram, btnFacebook, btnBrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        btnMessage = findViewById(R.id.btnMessage);
        btnCall = findViewById(R.id.btnCall);
        btnInstagram = findViewById(R.id.btnInstagram);
        btnFacebook = findViewById(R.id.btnFacebook);
        btnBrowser = findViewById(R.id.btnBrowser);

        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("sms:"));
                startActivity(intent);

            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:7008683249"));
                startActivity(intent);

            }
        });

        btnInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/"));
                startActivity(intent);

            }
        });

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"));
                startActivity(intent);

            }
        });

        btnBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.spectrum.com"));
                startActivity(intent);

            }
        });
    }
}
