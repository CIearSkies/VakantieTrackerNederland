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

public class detailAdapter extends ArrayAdapter<VakantieItem> {
    public detailAdapter(Context context, ArrayList<VakantieItem> vas){
        super(context, 0 , vas);}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        VakantieItem va = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_detail_adapter,parent,false);
        }

        TextView regiotxt = (TextView) convertView.findViewById(R.id.NMZ_txt);

        TextView datatxt = (TextView) convertView.findViewById(R.id.datums_txt);
        return convertView;
    }
}