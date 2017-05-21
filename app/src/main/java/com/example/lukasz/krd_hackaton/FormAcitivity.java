package com.example.lukasz.krd_hackaton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import java.util.Scanner;

public class FormAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_acitivity);
        Intent intencja = getIntent();
        String text = intencja.getStringExtra("ocr");
        Log.d("Tag","Read text: "+text);
        text=text.replaceAll("\\s+","");
        Log.d("Tag","Formated text: "+text);
        String nrDowodu = "";
        for (int i = 5; i <= 13; i++) {
            nrDowodu += text.charAt(i);
        }
        String dataUrodzenia ="";
        String rokUrodzenia="19";
        for(int i=29;i<=30;i++)
        {
            rokUrodzenia+=text.charAt(i);
        }
        rokUrodzenia+=".";
        String miesiacUrodzenia="";
        String dzienUrodzenia="";
        for(int i=31;i<=32;i++)
        {
            miesiacUrodzenia+=text.charAt(i);
        }
        miesiacUrodzenia+=".";
        for(int i=33;i<=34;i++)
        {
            dzienUrodzenia+=text.charAt(i);
        }
        String rokWaznosci="20";
        for(int i=37;i<=38;i++)
        {
            rokWaznosci+=text.charAt(i);
        }
        rokWaznosci+=".";
        String miesiacWaznosci="";
        String dzienWaznosci="";
        for(int i=39;i<=40;i++)
        {
            miesiacWaznosci+=text.charAt(i);
        }
        miesiacWaznosci+=".";
        for(int i=41;i<=42;i++)
        {
            dzienWaznosci+=text.charAt(i);
        }
        dataUrodzenia=rokUrodzenia+miesiacUrodzenia+dzienUrodzenia;
        String dataWaznosci=rokWaznosci+miesiacWaznosci+dzienWaznosci;
        int i;
        for(i=43;Character.isDigit(text.charAt(i));i++){}
        String nazwisko="";
        for(;text.charAt(i)=='<';i++){nazwisko+=text.charAt(i);}
        i++;
        String imie="";
        for(;text.charAt(i)=='<';i++){imie+=text.charAt(i);}

        ((EditText)findViewById(R.id.edit_nrDowodu)).setText(nrDowodu);
        ((EditText)findViewById(R.id.edit_dataUrodzenia)).setText(dataUrodzenia);
        ((EditText)findViewById(R.id.edit_dataWaznosci)).setText(dataWaznosci);
        ((EditText)findViewById(R.id.edit_nazwisko)).setText(nazwisko);
        ((EditText)findViewById(R.id.edit_imie)).setText(imie);
    }
}
