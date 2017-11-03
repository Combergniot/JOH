package com.copernicana.tripregistry.model.trip;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "grupy")
public class Group {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
      
      private int adultsNo;
      private int childrenNo;
      private int staffNo;
      private String age;
      
      @OneToOne
      @JoinColumn(name="wycieczki_id")
      private Trip trip;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAdultsNo() {
        return adultsNo;
    }

    public void setAdultsNo(int adultsNo) {
        this.adultsNo = adultsNo;
    }

    public int getChildrenNo() {
        return childrenNo;
    }

    public void setChildrenNo(int childrenNo) {
        this.childrenNo = childrenNo;
    }

    public int getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(int staffNo) {
        this.staffNo = staffNo;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    
    
      
      
      

}
