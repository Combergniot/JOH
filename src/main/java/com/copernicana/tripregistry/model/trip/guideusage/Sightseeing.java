
package com.copernicana.tripregistry.model.trip.guideusage;

import com.copernicana.tripregistry.model.trip.Guide;
import com.copernicana.tripregistry.model.trip.Trip;
import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("zwiedzanie")
public class Sightseeing extends GuideUsage {
    
   @Temporal(TemporalType.DATE)
   private Date date;
   
   private String hour;

   private boolean gingerbread;
   private boolean nalewki;
   private boolean meetingWithExecutioner;
   private boolean meetingWithCopernicus;
   
  private boolean pilotage;

    public Sightseeing(Date date, String hour, boolean gingerbread, boolean nalewki, boolean meetingWithExecutioner, boolean meetingWithCopernicus, boolean pilotage, String name, Trip trip, List<Guide> guides) {
        super(name, trip, guides);
        this.date = date;
        this.hour = hour;
        this.gingerbread = gingerbread;
        this.nalewki = nalewki;
        this.meetingWithExecutioner = meetingWithExecutioner;
        this.meetingWithCopernicus = meetingWithCopernicus;
        this.pilotage = pilotage;
    }
   


    public Sightseeing() {
    }
   
   

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }



    public boolean isGingerbread() {
        return gingerbread;
    }

    public void setGingerbread(boolean gingerbread) {
        this.gingerbread = gingerbread;
    }

    public boolean isNalewki() {
        return nalewki;
    }

    public void setNalewki(boolean nalewki) {
        this.nalewki = nalewki;
    }

    public boolean isMeetingWithExecutioner() {
        return meetingWithExecutioner;
    }

    public void setMeetingWithExecutioner(boolean meetingWithExecutioner) {
        this.meetingWithExecutioner = meetingWithExecutioner;
    }

    public boolean isMeetingWithCopernicus() {
        return meetingWithCopernicus;
    }

    public void setMeetingWithCopernicus(boolean meetingWithCopernicus) {
        this.meetingWithCopernicus = meetingWithCopernicus;
    }

    public boolean isPilotage() {
        return pilotage;
    }

    public void setPilotage(boolean pilotage) {
        this.pilotage = pilotage;
    }
    
    
   
   
           	
   
   
   

}
