package com.copernicana.tripregistry.model.trip;

import com.copernicana.tripregistry.model.trip.guideusage.GuideUsage;
import com.copernicana.tripregistry.model.trip.attraction.Attraction;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "wycieczki")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFrom;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateTo;
    
    private boolean confirmed;
    private boolean advance;

    @ManyToOne(cascade = CascadeType.ALL)
    private Company company;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "trip")
    private Group group;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trip")
    private List<Meal> meals;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trip")
    private List<Accomodation> accomodations;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trip")
    private List<GuideUsage> attractionsWithGuide;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trip")
    private List<Attraction> attractions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public List<Accomodation> getAccomodations() {
        return accomodations;
    }

    public void setAccomodations(List<Accomodation> accomodations) {
        this.accomodations = accomodations;
    }

    public List<GuideUsage> getAttractionsWithGuide() {
        return attractionsWithGuide;
    }

    public void setAttractionsWithGuide(List<GuideUsage> attractionsWithGuide) {
        this.attractionsWithGuide = attractionsWithGuide;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public boolean isAdvance() {
        return advance;
    }

    public void setAdvance(boolean advance) {
        this.advance = advance;
    }
    
    

    @Override
    public String toString() {
        return "Trip{" + "id=" + id + ", dateFrom=" + dateFrom + ", " +
                "dateTo=" + dateTo + ", company=" + company + ", group=" + group +
                ", meals=" + meals + ", accomodations=" + accomodations + ", " +
                "attractionsWithGuide=" + attractionsWithGuide + ", attractions=" + attractions + '}';
    }
    
    
    
    
    
    

}
