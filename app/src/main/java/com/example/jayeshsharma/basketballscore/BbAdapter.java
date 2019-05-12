package com.example.jayeshsharma.basketballscore;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class BbAdapter extends ArrayAdapter<data> {
    public BbAdapter(Context context,ArrayList d){
        super(context,0,d);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        data d=getItem(position);
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.bb_lay,parent);}
        TextView e3=(TextView) convertView.findViewById(R.id.s1);
        TextView e4=(TextView) convertView.findViewById(R.id.s2);
        EditText e1=convertView.findViewById(R.id.t1);
        EditText e2= convertView.findViewById(R.id.t2);
        e1.setText(d.getNameA());
        e2.setText(d.getNameB());
        e3.setText(d.getScoreA());
        e4.setText(d.getScoreB());
        return convertView;
    }
}
