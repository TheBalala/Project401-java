package com.example.project401_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.core.Amplify;

public class Complain extends AppCompatActivity {
com.amplifyframework.datastore.generated.model.Complain complain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);
        Button saveComplain = findViewById(R.id.saveComplain);
        EditText description = findViewById(R.id.DescriptionText);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Complain.this);
        String cityName = sharedPreferences.getString("cityName","cityName");
        String category = sharedPreferences.getString("category","category");
        String username = sharedPreferences.getString("username","username");
        saveComplain.setOnClickListener(v -> {

             complain = com.amplifyframework.datastore.generated.model.Complain.builder()
                    .description(description.getText().toString())
                     .state("sent")
                     .categoryName(category)
                     .cityName(cityName)
                     .username(username)
                    .build();

            Amplify.API.mutate(ModelMutation.create(complain),
                    response -> Log.i("complain", "complain success " + response.getData().getId()),
                    error -> Log.e("complain", "complain failed", error)
            );
//                description.getText();
        });


    }
}