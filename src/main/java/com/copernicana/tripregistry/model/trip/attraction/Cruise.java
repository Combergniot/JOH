package com.copernicana.tripregistry.model.trip.attraction;

import com.copernicana.tripregistry.model.trip.Trip;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("rejs")
public class Cruise extends Attraction{

    private boolean wanda;
    private boolean katarzynka;
    private boolean lodzieFlisacze;

    public Cruise(Date date, String hour, String name, Trip trip, boolean wanda, boolean katarzynka, boolean lodzieFlisacze) {
        super(date, hour, name, trip);
        this.wanda = wanda;
        this.katarzynka = katarzynka;
        this.lodzieFlisacze = lodzieFlisacze;
    }

    public Cruise(boolean wanda, boolean katarzynka, boolean lodzieFlisacze) {
        this.wanda = wanda;
        this.katarzynka = katarzynka;
        this.lodzieFlisacze = lodzieFlisacze;
    }

    public boolean isWanda() {
        return wanda;
    }

    public void setWanda(boolean wanda) {
        this.wanda = wanda;
    }

    public boolean isKatarzynka() {
        return katarzynka;
    }

    public void setKatarzynka(boolean katarzynka) {
        this.katarzynka = katarzynka;
    }

    public boolean isLodzieFlisacze() {
        return lodzieFlisacze;
    }

    public void setLodzieFlisacze(boolean lodzieFlisacze) {
        this.lodzieFlisacze = lodzieFlisacze;
    }
}
