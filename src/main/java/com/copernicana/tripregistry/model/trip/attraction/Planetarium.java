
package com.copernicana.tripregistry.model.trip.attraction;

import com.copernicana.tripregistry.model.trip.Trip;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("planetarium")
public class Planetarium extends Attraction {
    
    private String seance;

    public Planetarium() {
    }
    
    

    public Planetarium(String seance, Date date, String hour, String name, Trip trip) {
        super(date, hour, name,trip);
        this.seance = seance;
    }
    
    

    public String getSeance() {
        return seance;
    }

    public void setSeance(String seance) {
        this.seance = seance;
    }
    
    

}
