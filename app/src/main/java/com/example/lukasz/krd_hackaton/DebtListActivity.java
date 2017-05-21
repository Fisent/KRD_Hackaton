package com.example.lukasz.krd_hackaton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lukasz.krd_hackaton.JavaClasses.Base;
import com.example.lukasz.krd_hackaton.JavaClasses.Creditor;
import com.example.lukasz.krd_hackaton.JavaClasses.Debt;
import com.example.lukasz.krd_hackaton.JavaClasses.Income;

import java.util.LinkedList;
import java.util.List;

public class DebtListActivity extends AppCompatActivity
{

    public static List<Debt> debts;
    private ArrayAdapter<Debt> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debt_list);

        debts = new LinkedList<>();

    }

    @Override
    protected void onResume(){
        super.onResume();

        setList();
    }

    private void setList(){
        for(Creditor c : Base.creditors){
            for(Debt d : c.debts){
                debts.add(d);
            }
        }

        ListView list = (ListView) findViewById(R.id.debt_list_view);
        adapter = new ArrayAdapter<Debt>(this, android.R.layout.simple_list_item_1, debts);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Intent intent = new Intent(getBaseContext(), DebtDetailsActivity.class);
                intent.putExtra("index", i);
                startActivity(intent);
            }
        });

    }
}
