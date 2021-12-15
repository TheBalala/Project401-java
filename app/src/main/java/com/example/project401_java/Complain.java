package com.example.project401_java;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
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
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Complain extends AppCompatActivity {
    public static final int REQUEST_FOR_FILE = 999;
    String fileName;
    InputStream inputStream;
    private double lat;
    private double lon;
    private FusedLocationProviderClient fusedLocationClient;
com.amplifyframework.datastore.generated.model.Complain complain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);
        EditText description = findViewById(R.id.DescriptionText);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Complain.this);
        String cityName = sharedPreferences.getString("cityName","cityName");
        String category = sharedPreferences.getString("category","category");
        String username = sharedPreferences.getString("username","username");

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1212);


        }else {
            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location != null) {
                                lat = location.getLatitude();
                                lon = location.getLongitude();
                                Toast.makeText(Complain.this, "Location: " + location, Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Complain.this, "null", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
        }

        });

        Button button = findViewById(R.id.saveComplain);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Complain.this, "submitted!", Toast.LENGTH_LONG).show();
                if (fileName != null) {
                    Amplify.Storage.uploadInputStream(
                            fileName,
                            inputStream,
                            results -> Log.i("MyAmplifyApp", "Successfully uploaded: " + results.getKey()),
                            storageFailure -> Log.e("MyAmplifyApp", "Upload failed", storageFailure)
                    );
                }
                complain = com.amplifyframework.datastore.generated.model.Complain.builder()
                        .description(description.getText().toString())
                        .state("sent")
                        .categoryName(category)
                        .cityName(cityName)
                        .username(username)
                        .fileUrl(fileName)
                        .lat(lat)
                        .lon(lon)
                        .build();

                Amplify.API.mutate(ModelMutation.create(complain),
                        response -> Log.i("complain", "complain success " + response.getData().getId()),
                        error -> Log.e("complain", "complain failed", error)
                );
                finish();
            }
        });

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