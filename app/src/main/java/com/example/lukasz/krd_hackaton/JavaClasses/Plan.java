package com.example.lukasz.krd_hackaton.JavaClasses;


import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Plan {

    public static Result result(List<Creditor> creditors, List<Income> incomes) {

        List<Payment> pays = new LinkedList<>();

        for(Creditor c: creditors)
            for(Debt d: c.debts)
                pays.add(new Payment(d));

        Collections.sort(pays, new Comparator<Payment>() {
            @Override
            public int compare(Payment p1, Payment p2) {
                return (int)((p2.priority - p1.priority) * 16384);
            }
        });

        double sum = 0;

        for(Payment p: pays)
            sum += p.debt.value + p.debt.additionalDebt;

        Collections.sort(incomes, new Comparator<Income>() {
            @Override
            public int compare(Income i1, Income i2) {
                return MyDate.dif(i2.date, i1.date);
            }
        });

        double cash = 0;
        MyDate date = MyDate.now();

        for(Income in: incomes){
            if(cash >= sum)
                break;
            cash += in.value;
            date = in.date;
        }

        if(cash < sum)
            date = null;

        for(int i = 0; i < pays.size(); i++)
            pays.get(i).priority = i + 1;

        return new Result(date, sum, pays);
    }

    static class Payment{

        public Payment(Debt debt){
            this.debt = debt;

            priority = debt.lateRate * Math.pow(debt.value, 0.25) * MyDate.dif(debt.date, MyDate.now());
        }

        public Debt debt;
        public double priority;

        public String toString(){
            return priority + ". " + debt.toString();
        }
    }

    public static class Result{

        public Result(MyDate splata, double doSplaty, List<Payment> oplaty){
            this.splata = splata;
            this.doSplaty = doSplaty;
            this.oplaty = oplaty;
        }

        public MyDate splata;
        public double doSplaty;
        public List<Payment> oplaty;

    }

}
