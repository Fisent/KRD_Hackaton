package com.example.lukasz.krd_hackaton;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.lukasz.krd_hackaton.JavaClasses.Base;
import com.example.lukasz.krd_hackaton.JavaClasses.Debt;

import java.util.List;

/**
 * Created by lukasz on 21/05/2017.
 */

public class MySpecialAdapter extends ArrayAdapter<Object>
{

    private List<Object> debts;

    public MySpecialAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Object> objects)
    {
        super(context, resource, objects);
        debts = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Object debt = debts.get(position);
        TextView view = (TextView) convertView.findViewById(R.id.text1);
        //TUTAJ PISZ

        view.setText(Html.fromHtml(debt.toString()));

        return super.getView(position, convertView, parent);
    }
}
