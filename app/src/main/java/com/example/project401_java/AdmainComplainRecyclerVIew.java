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
import android.widget.Button;

import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;

import java.util.ArrayList;
import java.util.HashMap;

public class AdmainComplainRecyclerVIew extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ComplainAdpter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    Button history;
    ArrayList<com.amplifyframework.datastore.generated.model.Complain> listComplain = new ArrayList<>();
    HashMap<String, com.amplifyframework.datastore.generated.model.Category> listCategory = new HashMap<>();
    Handler handler;
    String cityName;
    String categoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admain_complain_recycler_view);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(AdmainComplainRecyclerVIew.this);
        cityName = sharedPreferences.getString("cityName", "cityName");
        categoryName = sharedPreferences.getString("category", "category");

        handler = new Handler(Looper.getMainLooper(),
                new Handler.Callback() {
                    @Override
                    public boolean handleMessage(@NonNull Message message) {
                        if (message.what == 1){
                            if (listCategory.containsKey(categoryName)) {
                                listComplain = (ArrayList<com.amplifyframework.datastore.generated.model.Complain>) listCategory.get(categoryName).getComplain();
                                System.out.println(listComplain.toString());
                            }
                        }else if (message.what == 2){
                            recyclerView.getAdapter().notifyDataSetChanged();
                        }

                        return false;
                    }
                });

        createTasksList(cityName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        buildRecycl();
    }

    public void createTasksList(String cityName) {

        Amplify.API.query(
                ModelQuery.list(com.amplifyframework.datastore.generated.model.Category.class, com.amplifyframework.datastore.generated.model.Category.CITY_NAME.contains(cityName)),
                response -> {
                    for (com.amplifyframework.datastore.generated.model.Category category : response.getData()) {
                        if (category.getCategoryName().equals(categoryName)){
                            listComplain = (ArrayList<com.amplifyframework.datastore.generated.model.Complain>) category.getComplain();
                            Log.i("MyAmplifyApp", listComplain.toString());
                            System.out.println("alaaaaaaaaa complaiiiiin "+listComplain.toString());
                        }

                    }
                    System.out.println("alaaaaaaaaa complaiiiiin "+listComplain.toString());
                    handler.sendEmptyMessage(1);
                    handler.sendEmptyMessage(2);

                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );

    }
    public void buildRecycl (){
        recyclerView = findViewById(R.id.allTaskRecyclerView1);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(AdmainComplainRecyclerVIew.this);
        mAdapter = new ComplainAdpter(listComplain);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);

    }
}