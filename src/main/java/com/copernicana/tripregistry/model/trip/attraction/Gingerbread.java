
package com.copernicana.tripregistry.model.trip.attraction;

import com.copernicana.tripregistry.model.trip.Trip;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
//TODO Do poprawki, są trzy piernikarnie - każda z innym repertuarem

@Entity
@DiscriminatorValue("pierniki")
public class Gingerbread extends Attraction {
    
    private boolean gingerbreadPresent;

    public Gingerbread(boolean gingerbreadPresent, Date date, String hour, String name, Trip trip) {
        super(date, hour, name, trip);
        this.gingerbreadPresent = gingerbreadPresent;
    }

    public Gingerbread() {
    }

    public boolean isGingerbreadPresent() {
        return gingerbreadPresent;
    }

    public void setGingerbreadPresent(boolean gingerbreadPresent) {
        this.gingerbreadPresent = gingerbreadPresent;
    }
    
    
    
    

}
