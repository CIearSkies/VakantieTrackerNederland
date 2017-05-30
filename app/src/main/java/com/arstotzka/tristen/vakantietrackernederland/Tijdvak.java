package com.arstotzka.tristen.vakantietrackernederland;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Tristen on 30-5-2017.
 */

public class Tijdvak implements Serializable{
    String region;
    Date startdate;
    Date enddate;

    public Tijdvak(String region, Date startdate, Date enddate) {
        this.region = region;
        this.startdate = startdate;
        this.enddate = enddate;
    }
}
