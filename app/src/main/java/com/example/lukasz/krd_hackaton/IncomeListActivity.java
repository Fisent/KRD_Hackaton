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
import com.example.lukasz.krd_hackaton.JavaClasses.Income;
import com.example.lukasz.krd_hackaton.JavaClasses.MyDate;

import java.util.LinkedList;

public class IncomeListActivity extends AppCompatActivity
{
    public static LinkedList<Income> incomes;

    private ArrayAdapter<Income> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_list);

        incomes = new LinkedList<>();
        setList();
    }

    @Override
    protected void onResume(){
        super.onResume();
        setList();
    }

    private void setList(){
        ListView list = (ListView) findViewById(R.id.income_list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Intent intent = new Intent(getBaseContext(), IncomeDeatilsActivity.class);
                intent.putExtra("index", i);
                startActivity(intent);
            }
        });
        adapter = new ArrayAdapter<Income>(getBaseContext(), android.R.layout.simple_list_item_1, incomes);
        list.setAdapter(adapter);
    }

    public void onBackClick(View view){
        onBackPressed();
    }

    public void onNextClick(View view){
        Intent i = new Intent(this, DebtListActivity.class);
        startActivity(i);
    }

    public void onAddIncomeClick(View view){
        incomes.add(new Income(new MyDate(2017,4), 0));
        System.out.println("dodano dupa");

        adapter.notifyDataSetChanged();
    }
}
