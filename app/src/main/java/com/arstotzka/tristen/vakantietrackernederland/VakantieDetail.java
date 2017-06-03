package com.arstotzka.tristen.vakantietrackernederland;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class VakantieDetail extends AppCompatActivity {
TextView title;
ListView data;
ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vakantie_detail);

        title = (TextView) findViewById(R.id.vakantie_dt_title);
        data = (ListView) findViewById(R.id.dataList);

        Intent i = getIntent();
        VakantieItem vakantieItem = (VakantieItem) i.getParcelableExtra("VAKANTIE_ITEM");

        //adapter= new hoofdAdapter(this,vakanties);
        //detailAdapter.setAdapter(adapter);
    }
}
