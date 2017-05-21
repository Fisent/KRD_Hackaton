package com.example.lukasz.krd_hackaton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lukasz.krd_hackaton.JavaClasses.Base;
import com.example.lukasz.krd_hackaton.JavaClasses.Creditor;

public class CreditorsListActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditors_list);


    }

    private void populateList(){
        ListView list = (ListView) findViewById(R.id.creditors_list);
        list.setAdapter(new ArrayAdapter<Creditor>(this, R.layout.item_list_huge, Base.creditors));
    }
}
