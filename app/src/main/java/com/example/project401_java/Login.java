package com.example.project401_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.User;
import com.amplifyframework.storage.s3.AWSS3StoragePlugin;

public class Login extends AppCompatActivity {
Button login;
Button signup;
EditText userName;
EditText password;
User userForAuth;
String username1;
Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        configureAmplify();
        setTitle("Login");


        login = (Button) findViewById(R.id.loged);
        signup = (Button) findViewById(R.id.signup_button);
        userName = (EditText) findViewById(R.id.hy);
        password = (EditText) findViewById(R.id.password);

        login.setOnClickListener(view -> {
            signIn(userName.getText().toString(), password.getText().toString());
        });

        signup.setOnClickListener(view -> {
            Intent goToSignUp = new Intent(Login.this, SignUp.class);
            startActivity(goToSignUp);
        });


    }

    void signIn(String username, String password) {
        handler = new Handler(Looper.getMainLooper(),
                new Handler.Callback() {
                    @Override
                    public boolean handleMessage(@NonNull Message message) {
                        if(userForAuth.getAuth().equals("ADMIN") ){
                            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Login.this);
                            sharedPreferences.edit().putString("username",username1).apply();

                            System.out.println("ADMINNNNNNNNNNN "+userForAuth.getAuth());
                            Intent goToMain = new Intent(Login.this, MainActivity.class);
                            startActivity(goToMain);
                        }else{
                            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Login.this);
                            sharedPreferences.edit().putString("username",username1).apply();
                            Intent goToMain = new Intent(Login.this, MainActivity.class);
                            startActivity(goToMain);
                            System.out.println("Roleuserrrrrrrrrr "+userForAuth.getAuth());

                        }
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Login.this);
                        sharedPreferences.edit().putString("isAuthA",userForAuth.getAuth()).apply();
                        sharedPreferences.edit().putString("username",username1).apply();
                        return false;
                    }
                });
        Amplify.Auth.signIn(
                username,
                password,
                success -> {
                    Log.i("is sucsess", "signIn: worked " + success.toString());
                    Amplify.API.query(
                            ModelQuery.list(User.class, User.USERNAME.contains(username)),
                            response -> {
                                for (User user : response.getData()) {
                                    userForAuth = user;
                                    Log.i("MyAmplifyApp", user.getUsername());
                                }
                                username1 = userName.getText().toString();
                                handler.sendEmptyMessage(1);

                            },
                            error -> Log.e("MyAmplifyApp", "Query failure", error)
                    );
                },
                error -> Log.e("is sucess", "signIn: failed" + error.toString()));
    }
    private void configureAmplify() {
        // configure Amplify plugins
        try {
            Amplify.addPlugin(new AWSCognitoAuthPlugin());
            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.addPlugin(new AWSS3StoragePlugin());
            Amplify.configure(getApplicationContext());
        } catch (AmplifyException exception) {
            Log.e("is sucsess","onCreate: Failed to initialize Amplify plugins => " + exception.toString());
        }
    }

}