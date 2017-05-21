package com.example.lukasz.krd_hackaton;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lukasz.krd_hackaton.JavaClasses.Debt;
import com.example.lukasz.krd_hackaton.JavaClasses.MyDate;

import org.w3c.dom.Text;

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

        java.text.DecimalFormat df = new java.text.DecimalFormat("##.##");
        Debt debt = DebtListActivity.debts.get(index);
        year.setText(debt.date.getYear() + "");
        month.setText(debt.date.getMonth() + "");
        value.setText(df.format(debt.value));
        interest.setText(df.format(debt.lateRate));
        ((TextView)findViewById(R.id.creditor_text)).setText(debt.creditor.toString());
    }

    public void onSaveClick(View view){
        int y = -10;
        int m = -10;
        double v = -10;
        double i = -10;

        try{
            y = Integer.parseInt(year.getText().toString());
            m = Integer.parseInt(month.getText().toString());
            String str = value.getText().toString();
            str = str.replace(',', '.');
            v = Double.parseDouble(str);
            str = interest.getText().toString();
            str = str.replace(',', '.');
            i = Double.parseDouble(str);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if(m <= 0 || m >12){
            Toast.makeText(this, "Zły miesiąc", Toast.LENGTH_SHORT).show();
        }
        else if(y < 1900 || y > 2100){
            Toast.makeText(this, "Zły rok", Toast.LENGTH_SHORT).show();
        }
        else if(v < 0 || i < 0 || i >= 1){
            Toast.makeText(this, "Zła wartość lub odsetki" + v + "/" + i, Toast.LENGTH_SHORT).show();
        }
        else{
            Debt debt = DebtListActivity.debts.get(index);
            debt.date = new MyDate(y, m);
            debt.value = v;
            debt.lateRate = i;

            Toast.makeText(this, "Zmieniono!", Toast.LENGTH_SHORT).show();
            onBackPressed();
        }
    }
}
