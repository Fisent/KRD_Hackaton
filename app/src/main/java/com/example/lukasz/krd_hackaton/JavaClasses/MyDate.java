package com.example.lukasz.krd_hackaton.JavaClasses;

import java.util.Calendar;

/**
 * Created by juna8001 on 20.05.2017.
 */

public class MyDate {

    int months;

    public MyDate(int y, int m){
        months = 12 * y + m;
    }

    public void set(int y, int m){
        months = 12 * y + m;
    }

    public static int dif(MyDate first, MyDate sec){
        return sec.months - first.months;
    }

    public static MyDate now(){
        int months = Calendar.getInstance().getTime().getYear() * 12 + Calendar.getInstance().getTime().getMonth();
        return new MyDate(0, months);
    }

    public String toString(){
        return (months / 12) + " : " + ((months % 12) + 1);
    }

}
