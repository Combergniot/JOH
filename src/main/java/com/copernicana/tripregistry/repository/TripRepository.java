package com.copernicana.tripregistry.repository;

import com.copernicana.tripregistry.model.trip.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TripRepository extends CrudRepository <Trip, Long> {
    
    
    

    
}
