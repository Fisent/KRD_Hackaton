package com.example.lukasz.krd_hackaton.JavaClasses;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class Base {

    public static List<Creditor> creditors;
    public static Plan plan;

    static String[] names = new String[]{"White", "Black", "Grey", "Orange", "Blue", "Pink", "Red", "Yellow", "Green", "Brown", "Purple", "Magenta", "Cyan", "Violet", "Plumb"};

    public static void init(List<Creditor> creditors, Plan plan){
        Base.creditors = creditors;
        Base.plan = plan;
    }

    public static void randomInit(int creds, int minDebtsPerCred, int maxDebtsPerCred, double minRate, double maxRate, double minDebt, double maxDebt){
        Random r = new Random();

        creditors = new ArrayList<Creditor>();

        creds = Math.min(creds, 15);

        for(int c = 0; c < creds; c++){

            Creditor creditor = new Creditor(names[c]);
            creditors.add(creditor);

            int debts = r.nextInt(maxDebtsPerCred - minDebtsPerCred) + minDebtsPerCred;
            for(int d = 0; d < debts; d++){
                Debt debt = new Debt(creditor, getDate(r), getDouble(r, minRate, maxRate), getDouble(r, minDebt, maxDebt), 0);
                int m = MyDate.dif(debt.date, MyDate.now());
                debt.additionalDebt = debt.lateRate * m * debt.value;
                creditor.debts.add(debt);
            }
        }
    }

    static double getDouble(Random r, double min, double max){
        return r.nextDouble() * (max - min) + min;
    }

    static MyDate getDate(Random r){
        int y = Calendar.getInstance().getTime().getYear() + 1900 - r.nextInt(2) - 1;
        int m = r.nextInt(12);

        return new MyDate(y, m);
    }

}
