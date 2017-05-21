package com.example.lukasz.krd_hackaton.JavaClasses;

import java.util.Date;

public class Income
{
    public Income(MyDate date, double value){
        this.date = date;
        this.value = value;
    }

    public MyDate date;
    public double value;

    @Override
    public String toString(){
        return "Przychód: " + value + ", data: " + date.toString();
    }
}
