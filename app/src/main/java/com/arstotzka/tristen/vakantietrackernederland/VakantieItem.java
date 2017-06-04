package com.arstotzka.tristen.vakantietrackernederland;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Tristen on 30-5-2017.
 */

public class VakantieItem implements Serializable{
    public String name;
    public boolean compulsorydates;
    public ArrayList<Tijdvak> tijdvak;

    public VakantieItem(String name, boolean compulsorydates, ArrayList<Tijdvak> tijdvak) {
        this.name = name;
        this.compulsorydates = compulsorydates;
        this.tijdvak = tijdvak;
    }

    protected VakantieItem(Parcel in) {
        name = in.readString();
        compulsorydates = in.readByte() != 0;
    }
}
