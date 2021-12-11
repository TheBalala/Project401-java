package com.example.project401_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.City;

public class Complain extends AppCompatActivity {
com.amplifyframework.datastore.generated.model.Complain complain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);
        Button saveComplain = findViewById(R.id.saveComplain);
        EditText description = findViewById(R.id.DescriptionText);
//        saveComplain.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                 complain = com.amplifyframework.datastore.generated.model.Complain.builder()
//                        .description()
//                         .state()
//                         .category()
//                         .city()
//                         .user()
//                        .build();
//
//                Amplify.API.mutate(ModelMutation.create(todo),
//                        response -> Log.i("MyAmplifyApp", "Todo with id: " + response.getData().getId()),
//                        error -> Log.e("MyAmplifyApp", "Create failed", error)
//                );
//                description.getText();
//            }
//        });
//

    }
}