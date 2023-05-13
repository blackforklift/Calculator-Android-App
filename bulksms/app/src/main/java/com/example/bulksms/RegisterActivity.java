package com.example.bulksms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    EditText editTextEmail,editTextPassword;
    Button register_kayit,register_giris;
    FirebaseAuth lauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editTextEmail = findViewById(R.id.login_editTextEmail);
        editTextPassword=findViewById(R.id.login_editTextPassword);
        register_kayit = findViewById(R.id.Login_giris);
        register_giris = findViewById(R.id.login_kayit);

        lauth=FirebaseAuth.getInstance();
        register_giris.setOnClickListener(view -> {startActivity(new Intent(RegisterActivity.this,LoginActivity.class));});
        register_kayit.setOnClickListener(view -> {
           String email = editTextEmail.getText().toString();
           String password = editTextPassword.getText().toString();
            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(RegisterActivity.this,"Lütfen gerekli alanları boş bırakmayınız.",Toast.LENGTH_SHORT).show();
                return;
            }
            if(password.length()<6){
                Toast.makeText(RegisterActivity.this,"Şifreniz en az 6 karakterden oluşmalı",Toast.LENGTH_SHORT).show();
                return;
            }
           lauth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
               if(task.isSuccessful())
               {
                   Toast.makeText(RegisterActivity.this,"KAYIT BAŞARILI",Toast.LENGTH_SHORT).show();
               }
               else{
                   Toast.makeText(RegisterActivity.this,"KAYIT BAŞARISIZ",Toast.LENGTH_SHORT).show();
               }
           });


        });
    }
}