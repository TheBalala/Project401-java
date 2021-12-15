package com.example.project401_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Category;
import com.amplifyframework.datastore.generated.model.Complain;
import com.amplifyframework.datastore.generated.model.User;

import java.util.ArrayList;
import java.util.HashMap;

public class Profile extends AppCompatActivity {
ArrayList<Complain> listComplain = new ArrayList<>();
HashMap<String, Category> listCategory = new HashMap<>();
Handler handler;
User user1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        historyU();
    }
    public void historyU(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Profile.this);
        String username = sharedPreferences.getString("username","username");
        RecyclerView recyclerView = findViewById(R.id.allTaskRecyclerViews);
        Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message message) {
                recyclerView.getAdapter().notifyDataSetChanged();
                return false;
            }
        });
        Amplify.API.query(
                ModelQuery.list(Complain.class, Complain.USERNAME.contains(username)),
                response -> {
                    for (Complain complain : response.getData()) {
                        listComplain.add(complain);
                        Log.i("MyAmplifyApp", listComplain.toString());
                    }
                    System.out.println("alaaaaaaaaa complaiiiiin "+listComplain.toString());
//                    System.out.println("alaaaaaaaaa complaiiiiin "+user1.getComplain().toString());
                    handler.sendEmptyMessage(1);

                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)

        );
        recyclerView.setLayoutManager(new LinearLayoutManager(Profile.this));
        recyclerView.setAdapter(new ComplainAdpter(listComplain));
    }


}