package com.arstotzka.tristen.vakantietrackernederland;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Tristen on 30-5-2017.
 */

public class VakantieItem implements Parcelable{
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

    public static final Creator<VakantieItem> CREATOR = new Creator<VakantieItem>() {
        @Override
        public VakantieItem createFromParcel(Parcel in) {
            return new VakantieItem(in);
        }

        @Override
        public VakantieItem[] newArray(int size) {
            return new VakantieItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(name);
        dest.writeByte((byte) (compulsorydates ? 1 : 0));
    }
}
