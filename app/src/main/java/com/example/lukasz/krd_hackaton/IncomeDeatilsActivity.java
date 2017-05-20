package com.example.lukasz.krd_hackaton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lukasz.krd_hackaton.JavaClasses.Income;
import com.example.lukasz.krd_hackaton.JavaClasses.MyDate;

public class IncomeDeatilsActivity extends AppCompatActivity
{

    private int index;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_deatils);
        index = getIntent().getIntExtra("index", 999);

        populateViews();
    }

    public void populateViews(){
        Income i = IncomeListActivity.incomes.get(index);
        ((EditText)findViewById(R.id.income_year)).setText(i.date.getYear() + "");
        ((EditText)findViewById(R.id.income_month)).setText(i.date.getMonth() + "");
        ((EditText)findViewById(R.id.income_value)).setText(i.value + "");
    }

    public void onSaveClick(View view){
        EditText year = (EditText) findViewById(R.id.income_year);
        EditText month = (EditText) findViewById(R.id.income_month);
        EditText value = (EditText) findViewById(R.id.income_value);

        int y = -10;
        int m = -10;

        try
        {
            y = Integer.parseInt(year.getText().toString());
            m = Integer.parseInt(month.getText().toString());
        }
        catch(Exception e){

        }

        if(m <= 0 || m> 12){
            Toast.makeText(this, "Zły miesiąc", Toast.LENGTH_SHORT).show();
        }
        else if(y <1900 || y > 2100){
            Toast.makeText(this, "Zły rok", Toast.LENGTH_SHORT).show();
        }
        else if(value.getText().toString().equals("")){
            Toast.makeText(this, "Wpisz wartość", Toast.LENGTH_SHORT).show();
        }
        else{
            Income i = IncomeListActivity.incomes.get(index);
            i.date = new MyDate(y, m);
            i.value = Double.parseDouble(value.getText().toString());

            Toast.makeText(this, "Dodano!", Toast.LENGTH_LONG).show();
            ((EditText)findViewById(R.id.income_value)).setText("");
            ((EditText)findViewById(R.id.income_month)).setText("");
            ((EditText)findViewById(R.id.income_year)).setText("");

            onBackPressed();
        }
    }
}
