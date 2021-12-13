package com.example.project401_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;

import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Category;
import com.amplifyframework.datastore.generated.model.Complain;

import java.util.ArrayList;
import java.util.HashMap;

public class AdmainComplainRecyclerVIew extends AppCompatActivity {
    ArrayList<Complain> listComplain = new ArrayList<>();
    HashMap<String, Category> listCategory = new HashMap<>();
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admain_complain_recycler_view);
        complainRecyclerView();
    }


    public void complainRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.allTaskRecyclerView);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(AdmainComplainRecyclerVIew.this);
        String cityName = sharedPreferences.getString("cityName","cityName");
        String categoryName = sharedPreferences.getString("category","category");

        handler = new Handler(Looper.getMainLooper(),
                new Handler.Callback() {
                    @Override
                    public boolean handleMessage(@NonNull Message message) {
                        if (message.what == 1){
                            if (listCategory.containsKey(categoryName)){
                                listComplain = (ArrayList<Complain>) listCategory.get(categoryName).getComplain();
                                System.out.println("ddddddddddddddddddwwwwwwwwww"+listComplain.toString());
                            }
                        }else if (message.what == 2){
                            recyclerView.getAdapter().notifyDataSetChanged();
                        }
                        return false;
                    }
                });

        Amplify.API.query(
                ModelQuery.list(com.amplifyframework.datastore.generated.model.Category.class, com.amplifyframework.datastore.generated.model.Category.CITY_NAME.contains(cityName)),
                response -> {
                    for (Category category : response.getData()) {

                        listCategory.put(category.getCategoryName(),category);

                        Log.i("MyAmplifyApp", listComplain.toString());
                    }
                    System.out.println("alaaaaaaaaa complaiiiiin "+listComplain.toString());
                    handler.sendEmptyMessage(1);
                    handler.sendEmptyMessage(2);
                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );

        recyclerView.setLayoutManager(new LinearLayoutManager(AdmainComplainRecyclerVIew.this));
        recyclerView.setAdapter(new ComplainAdpter(listComplain));
    }
}