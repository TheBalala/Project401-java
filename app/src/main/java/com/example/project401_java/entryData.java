package com.example.project401_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Category;

public class entryData extends AppCompatActivity {
    Button save1;
    Button save2;
    Button save3;
    Button save4;

    EditText cityName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_data);
        save1 = findViewById(R.id.save1);
        save2 = findViewById(R.id.save2);
        save3 = findViewById(R.id.save3);
        save4 = findViewById(R.id.save4);
        cityName = findViewById(R.id.cityName);

        save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String city = cityName.getText().toString();

                water(city);
//                elect(city);
//                street(city);
//                others(city);
            }
        });
        save2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String city = cityName.getText().toString();

//                water(city);
                elect(city);
//                street(city);
//                others(city);
            }
        });  save3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String city = cityName.getText().toString();

//                water(city);
//                elect(city);
                street(city);
//                others(city);
            }
        });  save4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String city = cityName.getText().toString();

//                water(city);
//                elect(city);
//                street(city);
                others(city);
            }
        });
    }
public void water (String cityName){
    Category c1 =Category.builder()
                .categoryName("water")
                .cityName(cityName)
                .build();

        Amplify.API.mutate(ModelMutation.create(c1),
                response -> Log.i("MyAmplifyApp", "Todo with id: " +response.getData().getId() ),
                error -> Log.e("MyAmplifyApp", "Create failed", error)
        );
}
    public void elect (String cityName){
        Category c1 =Category.builder()
                .categoryName("electric")
                .cityName(cityName)
                .build();

        Amplify.API.mutate(ModelMutation.create(c1),
                response -> Log.i("MyAmplifyApp", "Todo with id: " +response.getData().getId() ),

                error -> Log.e("MyAmplifyApp", "Create failed", error)


        );

    }
    public void street (String cityName){
        Category c1 =Category.builder()
                .categoryName("street")
                .cityName(cityName)
                .build();

        Amplify.API.mutate(ModelMutation.create(c1),
                response -> Log.i("MyAmplifyApp", "Todo with id: " +response.getData().getId() ),
                error -> Log.e("MyAmplifyApp", "Create failed", error)
        );
    }
    public void others (String cityName){
        Category c1 =Category.builder()
                .categoryName("others")
                .cityName(cityName)
                .build();

        Amplify.API.mutate(ModelMutation.create(c1),
                response -> Log.i("MyAmplifyApp", "Todo with id: " +response.getData().getId() ),
                error -> Log.e("MyAmplifyApp", "Create failed", error)
        );
    }
}