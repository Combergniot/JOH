package com.copernicana.tripregistry.model.trip.attraction;

import com.copernicana.tripregistry.model.trip.Trip;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("mlyny") //<Młyny wiedzy
public class Mill extends Attraction{


    private boolean sightseeing;
    private boolean workshops;

    public Mill(Date date, String hour, String name, Trip trip, boolean sightseeing, boolean workshops) {
        super(date, hour, name, trip);
        this.sightseeing = sightseeing;
        this.workshops = workshops;
    }

    public Mill(boolean sightseeing, boolean workshops) {
        this.sightseeing = sightseeing;
        this.workshops = workshops;
    }

    public Mill() {
    }

    public boolean isSightseeing() {
        return sightseeing;
    }

    public void setSightseeing(boolean sightseeing) {
        this.sightseeing = sightseeing;
    }

    public boolean isWorkshops() {
        return workshops;
    }

    public void setWorkshops(boolean workshops) {
        this.workshops = workshops;
    }
}
