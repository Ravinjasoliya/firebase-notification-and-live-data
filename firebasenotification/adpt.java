package com.example.firebasenotification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by RAVIN on 14-03-2017.
 */

public class adpt extends BaseAdapter {
    Context context;
    ArrayList<Person> arrayList;
    public adpt(Context context,ArrayList<Person> arrayList)
    {
        this.context =context;
        this.arrayList=arrayList;

    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=layoutInflater.inflate(R.layout.mylayout,null);
        TextView name=(TextView)view.findViewById(R.id.name);
        TextView fname=(TextView)view.findViewById(R.id.firstname);
        Person person=arrayList.get(i);
        name.setText(person.getName());
        fname.setText(person.getFirstname());
        return view;
    }
}
