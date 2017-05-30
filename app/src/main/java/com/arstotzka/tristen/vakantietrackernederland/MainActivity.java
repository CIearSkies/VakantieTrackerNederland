package com.arstotzka.tristen.vakantietrackernederland;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
//Made by Tristen
public class MainActivity extends AppCompatActivity {
ListView hoofdList;
ArrayAdapter adapter;
ArrayList<VakantieItem> vakanties;
    Date startDate;
    Date endDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.hoofdList = (ListView) findViewById(R.id.hoofdList);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        Date startDate = null;
        try {
            startDate = dateFormat.parse("2016-10-16T22:00:00.000Z");
            Date endDate = dateFormat.parse("2017-12-07T10:00:00.000Z");
            Tijdvak tijdvak = new Tijdvak("Zuid-Hollland", startDate, endDate);
            ArrayList tijden = new ArrayList();
            tijden.add(tijdvak);
            VakantieItem vakantieItem = new VakantieItem("Zomervakantie", true, tijden);
            vakanties.add(vakantieItem);



            adapter= new hoofdAdapter(this,vakanties);
            hoofdList.setAdapter(adapter);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
