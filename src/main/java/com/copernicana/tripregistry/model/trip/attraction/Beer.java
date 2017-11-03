package com.copernicana.tripregistry.model.trip.attraction;

import com.copernicana.tripregistry.model.trip.Trip;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("piwo")
public class Beer extends Attraction {
    
    private boolean snacks;
    private boolean sightseeing;
    private boolean tasting;

    public Beer(boolean snacks, boolean sightseeing, boolean tasting, Date date, String hour, String name, Trip trip) {
        super(date, hour, name, trip);
        this.snacks = snacks;
        this.sightseeing = sightseeing;
        this.tasting = tasting;
    }

    public Beer() {
    }
    
    public boolean isSnacks() {
        return snacks;
    }

    public void setSnacks(boolean snacks) {
        this.snacks = snacks;
    }

    public boolean isSightseeing() {
        return sightseeing;
    }

    public void setSightseeing(boolean sightseeing) {
        this.sightseeing = sightseeing;
    }

    public boolean isTasting() {
        return tasting;
    }

    public void setTasting(boolean tasting) {
        this.tasting = tasting;
    }
}
