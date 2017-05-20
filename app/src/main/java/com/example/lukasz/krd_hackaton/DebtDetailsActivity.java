package com.example.lukasz.krd_hackaton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lukasz.krd_hackaton.JavaClasses.Debt;
import com.example.lukasz.krd_hackaton.JavaClasses.MyDate;

public class DebtDetailsActivity extends AppCompatActivity
{

    private int index;

    private EditText year;
    private EditText month;
    private EditText value;
    private EditText interest;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debt_details);

        index = getIntent().getIntExtra("index", 999);

        year = (EditText) findViewById(R.id.debt_year);
        month = (EditText) findViewById(R.id.debt_month);
        value = (EditText) findViewById(R.id.debt_value);
        interest = (EditText) findViewById(R.id.debt_interest);

        populate();
    }

    private void populate(){
        Debt debt = DebtListActivity.debts.get(index);
        year.setText(debt.date.getYear());
        month.setText(debt.date.getMonth());
        value.setText(debt.value + "");
        interest.setText(debt.lateRate + "");
    }

    public void onSaveClick(){
        int y = -10;
        int m = -10;
        double v = -10;
        double i = -10;

        try{
            y = Integer.parseInt(year.getText().toString());
            m = Integer.parseInt(month.getText().toString());
            v = Double.parseDouble(value.getText().toString());
            i = Double.parseDouble(interest.getText().toString());
        }
        catch (Exception e){

        }
        if(m <= 0 || m >12){
            Toast.makeText(this, "Zły miesiąc", Toast.LENGTH_SHORT).show();
        }
        else if(y < 1900 || y > 2100){
            Toast.makeText(this, "Zły rok", Toast.LENGTH_SHORT).show();
        }
        else if(v < 0 || i < 0){
            Toast.makeText(this, "Zła wartość lub odsetki", Toast.LENGTH_SHORT).show();
        }
        else{
            Debt debt = DebtListActivity.debts.get(index);
            debt.date = new MyDate(y, m);
            debt.value = v;
            debt.lateRate = i;

            year.setText("");
            month.setText("");
            value.setText("");
            interest.setText("");

            Toast.makeText(this, "Zmieniono!", Toast.LENGTH_SHORT).show();
            onBackPressed();
        }
    }
}
