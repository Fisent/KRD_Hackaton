package com.example.lukasz.krd_hackaton.JavaClasses;

import java.text.DecimalFormat;
import java.util.Date;

public class Debt {

    public MyDate date;
    public double lateRate;
    public double value;
    public double additionalDebt;
    public Creditor creditor;

    public Debt(Creditor creditor, MyDate date, double lateRate, double value, double additionalDebt){

        this.creditor = creditor;
        this.date = date;
        this.lateRate = lateRate;
        this.value = value;
        this.additionalDebt = additionalDebt;

    }

    public String toString(){

        DecimalFormat decimalFormat = new DecimalFormat("##.##");

        return creditor.name + "\nKwota: " + decimalFormat.format(value) + "\nData spłaty: " + date.toString() + "\nStopa odsetek: " + decimalFormat.format(lateRate) + "\nOdsetki: " + decimalFormat.format(additionalDebt);
    }

}
