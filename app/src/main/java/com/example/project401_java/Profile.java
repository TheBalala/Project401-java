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
    private RecyclerView recyclerView;
    private TasksAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
Button history;
ArrayList<Complain> listComplain = new ArrayList<>();
HashMap<String, Category> listCategory = new HashMap<>();
Handler handler;
User user1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        history = findViewById(R.id.history);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {;
//                historyU();
//                admin();
            }
        });
    }
    public void historyU(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Profile.this);
        String username = sharedPreferences.getString("username","username");

        Amplify.API.query(
                ModelQuery.list(Complain.class, Complain.USERNAME.contains(username)),
                response -> {
                    for (Complain complain : response.getData()) {
                        listComplain.add(complain);
                        Log.i("MyAmplifyApp", listComplain.toString());
                    }
                    System.out.println("alaaaaaaaaa complaiiiiin "+listComplain.toString());
//                    System.out.println("alaaaaaaaaa complaiiiiin "+user1.getComplain().toString());

                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)

        );

    }

//    public void admin(){
//
//
//    }
    public  void setAllTasksOnClickListener() {
        mAdapter.setOnItemClickListener(new TasksAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Complain task = listComplain.get(position);

//                openTaskDetails(task.getTitle(), task.getDescription(), task.getStatus());

            }
        });
    }
    public void createTasksList(String cityName) {

        Amplify.API.query(
                ModelQuery.list(Category.class, Category.CITY_NAME.contains(cityName)),
                response -> {
                    for (Category category : response.getData()) {
if (category.getCategoryName().equals("electric")){
    listComplain = (ArrayList<Complain>) category.getComplain();
    Log.i("MyAmplifyApp", listComplain.toString());
    System.out.println("alaaaaaaaaa complaiiiiin "+listComplain.toString());


}
//                        listCategory.put(category.getCategoryName(),category);

                    }
                    System.out.println("alaaaaaaaaa complaiiiiin "+listComplain.toString());
//                    System.out.println("alaaaaaaaaa complaiiiiin "+user1.getComplain().toString());

                    handler.sendEmptyMessage(1);
                    handler.sendEmptyMessage(2);

                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)

        );




    }
    public void buildRecycl (){
        recyclerView = findViewById(R.id.recucler);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(Profile.this);
        mAdapter = new TasksAdapter(listComplain);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);

    }
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Profile.this);
        String cityName = sharedPreferences.getString("cityName", "cityName");
        String categoryName = sharedPreferences.getString("category", "category");

        handler = new Handler(Looper.getMainLooper(),
                new Handler.Callback() {
                    @Override
                    public boolean handleMessage(@NonNull Message message) {
                        if (message.what == 1){
                            if (listCategory.containsKey(categoryName)) {
                                listComplain = (ArrayList<Complain>) listCategory.get(categoryName).getComplain();
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
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        buildRecycl();
        setAllTasksOnClickListener();



    }
}