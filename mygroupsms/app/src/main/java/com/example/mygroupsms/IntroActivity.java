package com.example.mygroupsms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

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