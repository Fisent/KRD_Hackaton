package com.example.lukasz.krd_hackaton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lukasz.krd_hackaton.JavaClasses.Debt;

public class DebtsListActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debts_list);

        populateList();
    }

    private void populateList(){
        ListView list = (ListView) findViewById(R.id.debts_list);
        list.setAdapter(new ArrayAdapter<Debt>(this, R.layout.item_list_huge));
    }
}
