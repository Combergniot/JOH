package com.copernicana.tripregistry.model;

import javax.persistence.*;

/**
 * Created by Marcin on 2017-07-06.
 */

// TODO - lista pozostałych atrakcji w Toruniu i poza nim -> atrakcje wewnętrzne i zewnętrzne

@Entity
@Table(name = "atrakcje")
public class TouristAttractions {
    private long id;

    public TouristAttractions() {
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
}
