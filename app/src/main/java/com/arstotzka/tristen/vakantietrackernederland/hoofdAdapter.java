package com.arstotzka.tristen.vakantietrackernederland;

import android.content.Context;
import android.graphics.Color;
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
        vakTitle.setText(va.name);
        if(position%2==0){vakTitle.setTextColor(Color.BLUE);}

        TextView regioNr = (TextView) convertView.findViewById(R.id.regio_ID_nr);
        regioNr.setText(va.tijdvak.get(0).region);

        TextView regioTxt = (TextView) convertView.findViewById(R.id.regio_ID_txt);
        if(va.tijdvak.get(0).region.equals("1")){ regioTxt.setText("Regio"); } else regioTxt.setText("Regio's");

        return convertView;
    }
}
