
package com.copernicana.tripregistry.model.trip.attraction;

import com.copernicana.tripregistry.model.trip.Trip;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("fort")
public class FortIV extends Attraction {
    
    private boolean torches;
            private boolean bonfire;
            private boolean hareAndHounds; // podchody
            private boolean kielbaski; 

    public FortIV() {
    }
            
            

    public FortIV(boolean torches, boolean bonfire, boolean hareAndHounds, boolean kielbaski, Date date, String hour, String name, Trip trip) {
        super(date, hour, name, trip);
        this.torches = torches;
        this.bonfire = bonfire;
        this.hareAndHounds = hareAndHounds;
        this.kielbaski = kielbaski;
    }

  
            
            

    public boolean isTorches() {
        return torches;
    }

    public void setTorches(boolean torches) {
        this.torches = torches;
    }

    public boolean isBonfire() {
        return bonfire;
    }

    public void setBonfire(boolean bonfire) {
        this.bonfire = bonfire;
    }

    public boolean isHareAndHounds() {
        return hareAndHounds;
    }

    public void setHareAndHounds(boolean hareAndHounds) {
        this.hareAndHounds = hareAndHounds;
    }

    public boolean isKielbaski() {
        return kielbaski;
    }

    public void setKielbaski(boolean kielbaski) {
        this.kielbaski = kielbaski;
    }
            
            
            
            
            
            
       

}
