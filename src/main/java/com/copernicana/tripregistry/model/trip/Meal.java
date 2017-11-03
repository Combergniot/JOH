package com.copernicana.tripregistry.model.trip;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="posilki")
public class Meal {
    
      @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
      
      @Temporal(TemporalType.DATE)
      private Date date;
      private String hour;
      private String mealType;
      private String place;
      
      @ManyToOne
      @JoinColumn(name="wycieczki_id")
      private Trip trip;

    public Meal(Date date, String hour, String mealType, String place, Trip trip) {
        this.date = date;
        this.hour = hour;
        this.mealType = mealType;
        this.place = place;
        this.trip = trip;
    }



    public Meal() {
    }
      
      
      

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
      
      
      
      
      
      
      

}
