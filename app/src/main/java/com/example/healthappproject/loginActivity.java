package com.example.healthappproject;

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

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView forget=findViewById(R.id.forget);
        EditText email=findViewById(R.id.EMAIL);
        EditText pass=findViewById(R.id.editText2);
        Button login=findViewById(R.id.Login);
        Button signup=findViewById(R.id.signup);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginActivity.this,signupActivity.class);
                startActivity(intent);
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail=email.getText().toString().trim();
                String password=pass.getText().toString().trim();
                if(mail.isEmpty())
                {
                    email.setError("Email Can not be Empty");
                    email.requestFocus();
                }
                else if(password.isEmpty())
                {
                    pass.setError("Password Can not be Empty");
                    pass.requestFocus();
                }
                else
                {
                    mAuth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Intent intent = new Intent(loginActivity.this,homepage.class);
                                startActivity(intent);
                                finish();
                            }
                            else
                            {
                                Toast.makeText(loginActivity.this, "Log in Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}