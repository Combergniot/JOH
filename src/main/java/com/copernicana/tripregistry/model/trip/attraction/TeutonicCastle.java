package com.copernicana.tripregistry.model.trip.attraction;

import com.copernicana.tripregistry.model.trip.Trip;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("zamek")
public class TeutonicCastle extends Attraction {

    private boolean sightseeing;
    private boolean komturia;
    private boolean fightShow;

    public TeutonicCastle(Date date, String hour, String name, Trip trip,
                          boolean sightseeing, boolean komturia, boolean fightShow) {
        super(date, hour, name, trip);
        this.sightseeing = sightseeing;
        this.komturia = komturia;
        this.fightShow = fightShow;
    }

    public TeutonicCastle(boolean sightseeing, boolean komturia, boolean fightShow) {
        this.sightseeing = sightseeing;
        this.komturia = komturia;
        this.fightShow = fightShow;
    }

    public TeutonicCastle() {
    }

    public boolean isSightseeing() {
        return sightseeing;
    }

    public void setSightseeing(boolean sightseeing) {
        this.sightseeing = sightseeing;
    }

    public boolean isKomturia() {
        return komturia;
    }

    public void setKomturia(boolean komturia) {
        this.komturia = komturia;
    }

    public boolean isFightShow() {
        return fightShow;
    }

    public void setFightShow(boolean fightShow) {
        this.fightShow = fightShow;
    }
}
