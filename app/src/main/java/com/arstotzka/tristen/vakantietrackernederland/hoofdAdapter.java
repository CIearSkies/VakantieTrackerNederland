package com.arstotzka.tristen.vakantietrackernederland;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class hoofdAdapter extends ArrayAdapter<VakantieItem> {
    public hoofdAdapter(Context context, ArrayList<VakantieItem> vas){
        super(context, 0 , vas);}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        VakantieItem va = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.hoofd_adapter,parent,false);
        }

        TextView vakTitle = (TextView) convertView.findViewById(R.id.vakantie_ID_txt);
        vakTitle.setText("Test");

        TextView regioNr = (TextView) convertView.findViewById(R.id.regio_ID_nr);
        regioNr.setText("Test");

        TextView regioTxt = (TextView) convertView.findViewById(R.id.regio_ID_txt);
        regioTxt.setText("Test");

        return convertView;
    }
}
