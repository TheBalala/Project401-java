package com.example.project401_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.amplifyframework.core.Amplify;

import java.io.File;
import java.util.Locale;

import android.widget.ImageView;
import android.widget.TextView;

import com.amplifyframework.core.Amplify;

import java.io.File;

public class ProblemDetails extends AppCompatActivity {
    private Handler handleImageView;
    private File downloadedImage;
    private ImageView img;
    private String key;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_problem_details);
            System.out.println(getIntent().getStringExtra("data"));
            getTask();
            key = getIntent().getStringExtra("file");
            img = findViewById(R.id.ali);
            handleImageView = new Handler(new Handler.Callback() {
                @Override
                public boolean handleMessage(@NonNull Message msg) {
                    setTaskImage();
                    return false;
                }
            });
            getFileFromApi();

            Double altitude = getIntent().getDoubleExtra("lat", 0);
            Double longitude = getIntent().getDoubleExtra("lon", 0);
            Log.i("ahmad", altitude + "long");
            Log.i("ahmad", longitude + "lat");
            Button loc = findViewById(R.id.lo);
            loc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?q=loc:%f,%f", altitude, longitude);
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                    startActivity(intent);
                }
            });

        }

        private void setTaskImage() {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 8; // down sizing image as it throws OutOfMemory  Exception for larger images
            Bitmap bitmap = BitmapFactory.decodeFile(downloadedImage.getAbsolutePath(), options);
            img.setImageBitmap(bitmap);
        }

        @SuppressLint("LongLogTag")
        private void getFileFromApi() {
            Amplify.Storage.downloadFile(

                    key,
                    new File(getApplicationContext().getFilesDir() + "test.jpg"),
                    success -> {
                        Log.i("getFileFromApi: successfully   ----> ", success.toString());
                        downloadedImage = success.getFile();
                        handleImageView.sendEmptyMessage(1);
                    },
                    failure -> Log.i("getFileFromApi:  failed  ---> ", failure.toString())
            );
        }


        public void getTask() {

            TextView textView = findViewById(R.id.userss);
            textView.setText(getIntent().getStringExtra("username"));

            TextView md = findViewById(R.id.descr);
            md.setText(getIntent().getStringExtra("des"));

            TextView sd = findViewById(R.id.states);
            sd.setText(getIntent().getStringExtra("state"));

        }
    }
