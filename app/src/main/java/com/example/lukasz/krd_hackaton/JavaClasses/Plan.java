package com.example.lukasz.krd_hackaton.JavaClasses;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Plan {

    public Plan(List<Creditor> creditors, List<Income> incomes) {

        List<Payment> pays = new LinkedList<>();

        for(Creditor c: creditors)
            for(Debt d: c.debts)
                pays.add(new Payment(d));

        Collections.sort(incomes, new Comparator<Income>() {
            @Override
            public int compare(Income i1, Income i2) {
                return MyDate.dif(i1.date, i2.date);
            }
        });

        for(Income in: incomes)
            System.out.print(in.date);

    }

    class Payment{

        public Payment(Debt debt){
            this.debt = debt;
            paid = 0;
        }

        public Debt debt;
        public double paid;
    }

}
