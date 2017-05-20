package com.example.lukasz.krd_hackaton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.lukasz.krd_hackaton.JavaClasses.*;

import java.util.ArrayList;
import java.util.List;

public class AktywnoscKamilaDoTestow extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktywnosc_kamila_do_testow);

        //TUTAJ PISZ KOD, KTORY ODPALI SIE PRZY WLACZENIU TEJ AKTYWNOSCI

        Log.i("Tag", "aaa");

        Base.randomInit(4, 1, 5, 0.005, 0.05, 300, 20000);

        List<Income> incomes = new ArrayList<>();

        incomes.add(new Income(new MyDate(2017, 6), 500));
        incomes.add(new Income(new MyDate(2017, 8), 500));
        incomes.add(new Income(new MyDate(2017, 7), 500));
        incomes.add(new Income(new MyDate(2017, 11), 500));
        incomes.add(new Income(new MyDate(2017, 3), 500));
        incomes.add(new Income(new MyDate(2017, 8), 500));
        incomes.add(new Income(new MyDate(2017, 9), 500));

        Base.plan = new Plan(Base.creditors, incomes);


    }
}
