package com.arstotzka.tristen.vakantietrackernederland;

import java.util.ArrayList;

/**
 * Created by Tristen on 30-5-2017.
 */

public class VakantieItem {
    public String name;
    public boolean compulsorydates;
    public ArrayList<Tijdvak> tijdvak;

    public VakantieItem(String name, boolean compulsorydates, ArrayList<Tijdvak> tijdvak) {
        this.name = name;
        this.compulsorydates = compulsorydates;
        this.tijdvak = tijdvak;
    }
}
