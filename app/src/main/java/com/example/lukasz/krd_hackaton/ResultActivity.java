package com.example.lukasz.krd_hackaton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lukasz.krd_hackaton.JavaClasses.Base;
import com.example.lukasz.krd_hackaton.JavaClasses.MyDate;
import com.example.lukasz.krd_hackaton.JavaClasses.Plan;
import com.google.android.gms.vision.text.Text;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        populate();
    }

    private void populate(){
        ListView list = (ListView) findViewById(R.id.payments_list);
        list.setAdapter(new ArrayAdapter<Plan.Payment>(this,R.layout.item_list_huge, Base.plan.oplaty));

        TextView tv = (TextView) findViewById(R.id.sum_to_pay);
        DecimalFormat f = new DecimalFormat("##.##");
        tv.setText(f.format(Base.plan.doSplaty));

        MyDate dateOfEnd = Base.plan.splata;
        TextView date = (TextView) findViewById(R.id.date_of_last_payment);
        // JEŚLI DATA JEST NULLEM, ZA CHINY NIE SPŁACISZ DŁUGÓW POJEBIE
        if(dateOfEnd != null)
            date.setText(dateOfEnd.toString());
        else
            date.setText("Nigdy!");
    }

    public void onMenuClick(View view){
        Intent i = new Intent(this, MainActivity.class);
        MainActivity.isComingFromResult = true;
        startActivity(i);
    }
}
