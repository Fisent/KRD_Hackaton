package com.example.lukasz.krd_hackaton;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lukasz.krd_hackaton.JavaClasses.Base;

public class MainActivity extends AppCompatActivity
{
    public static boolean isComingFromResult = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Base.creditors == null)
            Base.randomInit();

        if(Base.plan == null)
            ((Button)findViewById(R.id.show_plan)).setEnabled(false);
        else
            ((Button)findViewById(R.id.show_plan)).setEnabled(true);

        if(isComingFromResult){
            for(int i = 0; i<4; i++){
                android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
                manager.popBackStack();
            }
            isComingFromResult = false;
        }
    }

    public void onStworzHarmonogramClick(View view){
        Intent i = new Intent(this, IncomeListActivity.class);
        startActivity(i);
    }

    public void onTestClick(View view){
        Base.randomInit();
    }

    public void onCameraClick(View view){
        Intent i = new Intent(this, OCRActivity.class);
        startActivity(i);
    }

    public void onPlanClick(View view){
        Intent i = new Intent(this, ResultActivity.class);
        startActivity(i);
    }

    public void onDebtsListClick(View view){
        Intent i = new Intent(this, DebtsListActivity.class);
        startActivity(i);
    }

    public void onCreditorsListClick(View view){
        Intent i = new Intent(this, CreditorsListActivity.class);
        startActivity(i);
    }
}
