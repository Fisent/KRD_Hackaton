package com.example.lukasz.krd_hackaton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.util.Scanner;

public class FormAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_acitivity);
        Intent intencja = getIntent();
        String text = intencja.getStringExtra("ocr");
        text=text.replaceAll("\\s+","");
        String nrDowodu = "";
        for (int i = 5; i <= 13; i++) {
            nrDowodu += text.charAt(i);
        }
        ((EditText)findViewById(R.id.edit_nrDowodu)).setText(nrDowodu);
    }
}
