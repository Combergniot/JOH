package com.copernicana.tripregistry.service;

import com.copernicana.tripregistry.model.trip.Trip;
import com.copernicana.tripregistry.repository.TripRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepository;

    @Override
    @Transactional
    public void addTrip(Trip trip) {
        tripRepository.save(trip);

    }

    @Override
    @Transactional
    public Trip getOneTrip(long id) {
        return tripRepository.findOne(id);
    }
    
    @Override
    @Transactional
    public List<Trip> getAllTrips(){
    
        List <Trip> trips = new ArrayList<>();
        tripRepository.findAll().forEach(trips::add);     
    return trips;
    }

}
