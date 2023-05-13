package com.example.bulksms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
 EditText Login_emailEditText,Login_passwordEditText;
 Button login_giris;
 Button login_kayit;
    FirebaseAuth lauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Login_emailEditText =findViewById(R.id.login_editTextEmail);
        Login_passwordEditText =findViewById(R.id.login_editTextPassword);
        login_giris = findViewById(R.id.login_giris);
        login_kayit=findViewById(R.id.login_kayit);
        login_kayit.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
        });
        lauth= FirebaseAuth.getInstance();
        login_giris.setOnClickListener(view -> {
            String email = Login_emailEditText.getText().toString();
            String password = Login_passwordEditText.getText().toString();
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Lütfen gerekli alanları boş bırakmayınız.", Toast.LENGTH_SHORT).show();
                return;
            }
            lauth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
               if (task.isSuccessful()){
                   Toast.makeText(LoginActivity.this,"Giriş Başarılı",Toast.LENGTH_SHORT).show();
                   startActivity(new Intent(LoginActivity.this,MainActivity.class));

               }
               else{
                   Toast.makeText(LoginActivity.this,"Giriş Başarısız",Toast.LENGTH_SHORT).show();
               }

            });
        });

    }
}