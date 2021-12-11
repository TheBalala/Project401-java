package com.example.project401_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;

public class SignUp extends AppCompatActivity {
Button signUp;
EditText userName;
EditText email;
EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setTitle("Singup");
        signUp =  findViewById(R.id.button2);
        userName = findViewById(R.id.usernamesignum);
        email = findViewById(R.id.emailsugnup);
        password = findViewById(R.id.passwordsignup);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp(
                        userName.getText().toString(),
                        email.getText().toString(),
                        password.getText().toString());
            }
        });


    }
    void signUp(String username, String email, String password) {
        Amplify.Auth.signUp(
                username,
                password,
                AuthSignUpOptions.builder()
                        .userAttribute(AuthUserAttributeKey.email(), email)
                        .build(),
                success -> {
                    Log.i("signup", "signUp successful: " + success.toString());

                    Intent goToVerification = new Intent(SignUp.this, VerificationActivity.class);
                    goToVerification.putExtra("username", username);
                    goToVerification.putExtra("password", password);
                    goToVerification.putExtra("email", email);
                    startActivity(goToVerification);
                },
                error -> {
                    Log.e("SignUp", "signUp failed: " + error.toString());
                });
    }
}