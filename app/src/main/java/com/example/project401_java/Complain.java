package com.example.project401_java;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.core.Amplify;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Complain extends AppCompatActivity {
    public static final int REQUEST_FOR_FILE = 999;
    String fileName;
    InputStream inputStream;
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
//        Button button = findViewById(R.id.add);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(Complain.this, "submitted!", Toast.LENGTH_LONG).show();
//                if (fileName != null) {
//                    Amplify.Storage.uploadInputStream(
//                            fileName,
//                            inputStream,
//                            results -> Log.i("MyAmplifyApp", "Successfully uploaded: " + results.getKey()),
//                            storageFailure -> Log.e("MyAmplifyApp", "Upload failed", storageFailure)
//                    );
//                }
//                t = com.amplifyframework.datastore.generated.model.Complain.builder().(menuView.getText().toString()).title(mtask.getText().toString()).body(dtask.getText().toString()).state(stask.getText().toString()).file(fileName).build();
//                /*---------------------------------------------------*/
//
//                Amplify.API.mutate(
//                        ModelMutation.create(t),
//                        response -> Log.i("MyAmplifyApp", "Added Todo with id: " + response.getData().getId()),
//                        error -> Log.e("MyAmplifyApp", "Create failed", error)
//                );
//                finish();
//            }
//        });

        findViewById(R.id.addphoto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFileFromDevice();
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        try {
            inputStream = getContentResolver().openInputStream(data.getData());
            File files = new File(data.getData().getPath());
            fileName = files.getName();
            Log.i ("MyAmplifyApp", fileName);
            Toast.makeText(getApplicationContext(),"Added the file Successfully",Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    private void getFileFromDevice() {
        Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
        chooseFile.setType("*/*");
        chooseFile = Intent.createChooser(chooseFile, "Choose a File");
        startActivityForResult(chooseFile, REQUEST_FOR_FILE);
    }
}