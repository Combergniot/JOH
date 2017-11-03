package com.copernicana.tripregistry.service;

import com.copernicana.tripregistry.model.trip.Trip;
import java.util.List;


public interface TripService {
    
    void addTrip(Trip trip);
    Trip getOneTrip(long id);
    List<Trip> getAllTrips();
    
    
    
}
