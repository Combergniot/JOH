package com.copernicana.tripregistry.service;

import com.copernicana.tripregistry.model.trip.guideusage.Sightseeing;
import com.copernicana.tripregistry.repository.SightseeingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class SightseeingServiceImpl implements SightseeingService {

    @Autowired
     SightseeingRepository sightseeingRepository;
    
    @Transactional
    @Override
    public Iterable<Sightseeing> getAllSighteeings() {
        
        return sightseeingRepository.findAll();
    }

}
