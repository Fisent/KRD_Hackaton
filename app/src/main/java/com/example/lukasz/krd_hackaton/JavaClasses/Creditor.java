package com.example.lukasz.krd_hackaton.JavaClasses;

import java.util.ArrayList;
import java.util.List;

public class Creditor {
    public List<Debt> debts;
    public String name;

    public Creditor(String name){
        this.name = name;
        debts = new ArrayList<Debt>();
    }

    @Override
    public String toString(){
        return name;
    }
}
