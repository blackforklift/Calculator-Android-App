package com.example.bulksms;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class IntroActivity extends AppCompatActivity {
    FirebaseAuth lauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro2);
        findViewById(R.id.intro_kayit).setOnClickListener(view -> {startActivity(new Intent(IntroActivity.this,RegisterActivity.class));});
        findViewById(R.id.intro_giris).setOnClickListener(view -> {startActivity(new Intent(IntroActivity.this,LoginActivity.class));});
        lauth =FirebaseAuth.getInstance();

        if(lauth.getCurrentUser() != null){
            startActivity(new Intent(IntroActivity.this,MainActivity.class));

            Toast.makeText(IntroActivity.this,"Lütfen Bekleyin",Toast.LENGTH_SHORT).show();
        }

        }
    }
