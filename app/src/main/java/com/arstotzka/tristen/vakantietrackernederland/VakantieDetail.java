package com.arstotzka.tristen.vakantietrackernederland;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class VakantieDetail extends AppCompatActivity {
TextView title;
ListView data;
ArrayAdapter adapter;
ArrayList<Tijdvak> tijdvakken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vakantie_detail);

        tijdvakken=new ArrayList<Tijdvak>();

        title = (TextView) findViewById(R.id.vakantie_dt_title);
        data = (ListView) findViewById(R.id.dataList);

        Intent i = getIntent();
        VakantieItem item = (VakantieItem) i.getSerializableExtra("VAKANTIE_ITEM");

        title.setText(item.name);

        tijdvakken=item.tijdvak;
        adapter= new detailAdapter(this,tijdvakken);
        data.setAdapter(adapter);
    }
}
