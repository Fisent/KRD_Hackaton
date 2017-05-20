package com.example.lukasz.krd_hackaton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStworzHarmonogramClick(View view){
        Intent i = new Intent(this, ListaPrzychodowActivity.class);
        startActivity(i);
    }

    public void onTestClick(View view){
        Intent i = new Intent(this, AktywnoscKamilaDoTestow.class);
        startActivity(i);
    }
}
