package com.copernicana.tripregistry.model.trip.guideusage;

import com.copernicana.tripregistry.model.trip.Guide;
import com.copernicana.tripregistry.model.trip.Trip;
import java.io.Serializable;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "uslugi_przewodnickie")
@Inheritance
@DiscriminatorColumn(name = "TYP_USLUGI")
public abstract class GuideUsage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    public GuideUsage(String name, Trip trip, List<Guide> guides) {
        this.name = name;
        this.trip = trip;
        this.guides = guides;
    }



    public GuideUsage() {
    }

    @ManyToOne
    @JoinColumn(name = "wycieczki_id")
    private Trip trip;

    @ManyToMany
    @JoinTable(
            name = "PRZEWODNICY_ZWIEDZANIA",
            joinColumns = @JoinColumn(name = "ZWIEDZANIA_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PRZEWODNIK_ID", referencedColumnName = "ID"))
    private List<Guide> guides;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public List<Guide> getGuides() {
        return guides;
    }

    public void setGuides(List<Guide> guides) {
        this.guides = guides;
    }
    
    

}
