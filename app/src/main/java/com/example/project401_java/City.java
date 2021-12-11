package com.example.project401_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

public class City extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        setTitle("City");
        CardView amman = findViewById(R.id.amman);
        CardView ajlun = findViewById(R.id.ajlune);
        CardView alazraq = findViewById(R.id.balqa);
        CardView alsalt = findViewById(R.id.jarash);
        CardView madaba = findViewById(R.id.madaba);
        CardView karak = findViewById(R.id.karak);
        CardView tafile = findViewById(R.id.tafile);
        CardView maan = findViewById(R.id.maan);
        CardView alzarqa = findViewById(R.id.zarqa);
        CardView aqapa = findViewById(R.id.aqaba);
        CardView almafraq = findViewById(R.id.mafraq);
        CardView irbid = findViewById(R.id.irbid);
        amman.setOnClickListener(this);
        ajlun.setOnClickListener(this);
        alazraq.setOnClickListener(this);
        alsalt.setOnClickListener(this);
        madaba.setOnClickListener(this);
        karak.setOnClickListener(this);
        tafile.setOnClickListener(this);
        maan.setOnClickListener(this);
        alzarqa.setOnClickListener(this);
        aqapa.setOnClickListener(this);
        almafraq.setOnClickListener(this);
        irbid.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        CardView button = findViewById(v.getId());

        String cityName = button.getTransitionName();
        System.out.println("dddddddddddddddddddddddn "+cityName);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(City.this);
        sharedPreferences.edit().putString("cityName",cityName).apply();
        Intent intent = new Intent(City.this,Category.class);
        startActivity(intent);
    }
}