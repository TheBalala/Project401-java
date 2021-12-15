package com.example.project401_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.amplifyframework.datastore.generated.model.User;

public class Category extends AppCompatActivity implements View.OnClickListener {
    User userForAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        setTitle("Category");
        RelativeLayout electric = findViewById(R.id.electric);
        RelativeLayout water = findViewById(R.id.water);
        RelativeLayout street = findViewById(R.id.street);
        RelativeLayout others = findViewById(R.id.others);
        electric.setOnClickListener(this);
        water.setOnClickListener(this);
        street.setOnClickListener(this);
        others.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        SharedPreferences sharedPreferences1= PreferenceManager.getDefaultSharedPreferences(Category.this);
        String username = sharedPreferences1.getString("isAuthA", "username");
        System.out.println("ewfwefwefawefwefawefwef " + username);

        RelativeLayout button = findViewById(v.getId());

        String category = button.getTransitionName();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Category.this);
        sharedPreferences.edit().putString("category", category).apply();
        Intent intent;
        if (username.equals("ADMIN")) {
            intent = new Intent(Category.this, AdmainComplainRecyclerVIew.class);
            startActivity(intent);
        } else {
            intent = new Intent(Category.this, Complain.class);
            startActivity(intent);
        }


    }
}

