package com.example.lukasz.krd_hackaton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.Scanner;

public class FormAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_acitivity);
        Intent intencja = getIntent();
        String text = intencja.getStringExtra("ocr");
        Log.d("Tag", "Read text: " + text);
        text = text.replaceAll("\\s+", "");
        Log.d("Tag", "Formated text: " + text);
        String nrDowodu = "";
        int i=5;
        for (int j=0;j<9; i++) {
            nrDowodu += text.charAt(i);
            j++;
        }
        String dataUrodzenia = "";
        String rokUrodzenia = "19";
        i++;
        for(;!Character.isDigit(text.charAt(i));i++)
        {
        }
        for (int j=0;j<2; i++) {
            rokUrodzenia += text.charAt(i);
            j++;
        }
        rokUrodzenia += ".";
        String miesiacUrodzenia = "";
        String dzienUrodzenia = "";
        for (int j=0;j<2; i++) {
            miesiacUrodzenia += text.charAt(i);
            j++;
        }
        miesiacUrodzenia += ".";
        for (int j=0; j<2; i++) {
            dzienUrodzenia += text.charAt(i);
            j++;
        }
        String rokWaznosci = "20";
        i++;
        char plec=text.charAt(i);
        i++;
        for (int j=0; j<2; i++) {
            rokWaznosci += text.charAt(i);
            j++;
        }

        rokWaznosci += ".";
        String miesiacWaznosci = "";
        String dzienWaznosci = "";
        for (int j=0; j<2; i++) {
            miesiacWaznosci += text.charAt(i);
            j++;
        }
        miesiacWaznosci += ".";
        for (int j=0; j<2; i++) {
            dzienWaznosci += text.charAt(i);
            j++;
        }
        dataUrodzenia = rokUrodzenia + miesiacUrodzenia + dzienUrodzenia;
        String dataWaznosci = rokWaznosci + miesiacWaznosci + dzienWaznosci;
        i++;
        for (;!Character.isDigit(text.charAt(i)); i++) {
        }//skiping
        String nazwisko = "";
        i++;
        for (; text.charAt(i) != '<'; i++) {
            nazwisko += text.charAt(i);
        }
        i++;
        String imie = "";
        for (; text.charAt(i) != '<'; i++) {
            imie += text.charAt(i);
        }

        ((EditText) findViewById(R.id.edit_nrDowodu)).setText(nrDowodu);
        ((EditText) findViewById(R.id.edit_dataUrodzenia)).setText(dataUrodzenia);
        ((EditText) findViewById(R.id.edit_dataWaznosci)).setText(dataWaznosci);
        ((EditText) findViewById(R.id.edit_nazwisko)).setText(nazwisko);
        ((EditText) findViewById(R.id.edit_imie)).setText(imie);
        ((EditText) findViewById(R.id.edit_plec)).setText(plec+"");
    }
    public void menuActivity(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
