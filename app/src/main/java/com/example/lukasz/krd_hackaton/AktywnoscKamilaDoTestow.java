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


        Base.randomInit(4, 1, 5, 0.005, 0.05, 300, 20000);


    }
}
