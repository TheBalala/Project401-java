package com.example.project401_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.User;

public class VerificationActivity extends AppCompatActivity {
    EditText editText;
    private String username;
    private String password;
    Button varfyButton;
    private  String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        setTitle("Verification");
        editText = findViewById(R.id.verfi);
        varfyButton = findViewById(R.id.varfiButton);
        Intent intent = getIntent();
        username = intent.getExtras().getString("username", "");
        password = intent.getExtras().getString("password", "");
        email = intent.getExtras().getString("email", "");


        varfyButton.setOnClickListener(view -> verification(username, editText.getText().toString()));

    }

    void verification(String username, String confirmationNumber) {
        Amplify.Auth.confirmSignUp(
                username,
                confirmationNumber,
                success -> {
                    Log.i("varfy check", "verification: succeeded" + success.toString());
                    Intent goToSignIn = new Intent(VerificationActivity.this, Login.class);
                    goToSignIn.putExtra("username", username);
                    startActivity(goToSignIn);
                    buld(username,password,email);
                },
                error -> {
                    Log.e("varfy check", "verification: failed" + error.toString());
                });

    }
    public void buld(String username, String password, String email){
        User user = User.builder()
                .username(username)
                .email(email)
                .password(password)
                .auth("ROLE_USER")
                .build();

        Amplify.API.mutate(ModelMutation.create(user),
                response -> Log.i("MyAmplifyApp", "Todo with id: " + response.getData().getId()),
                error -> Log.e("MyAmplifyApp", "Create failed", error)
        );
    }
}