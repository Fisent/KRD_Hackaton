package com.example.lukasz.krd_hackaton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lukasz.krd_hackaton.JavaClasses.Base;
import com.example.lukasz.krd_hackaton.JavaClasses.Creditor;
import com.example.lukasz.krd_hackaton.JavaClasses.Debt;
import com.example.lukasz.krd_hackaton.JavaClasses.Income;
import com.example.lukasz.krd_hackaton.JavaClasses.MyDate;
import com.example.lukasz.krd_hackaton.JavaClasses.Plan;

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

        Base.randomInit(4, 1, 5, 0.005, 0.05, 300, 20000);

        List<Income> incomes = new ArrayList<>();

        incomes.add(new Income(new MyDate(2017, 6), 500));

        Base.plan = new Plan(Base.creditors, incomes);
        

    }
}
