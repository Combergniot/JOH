
package com.copernicana.tripregistry.service;

import com.copernicana.tripregistry.model.trip.attraction.Attraction;
import java.util.List;
import com.copernicana.tripregistry.repository.CompanyRepository;


public interface AttractionService {
    
    List<Attraction> getAllAttractions();
    
    List<Attraction> getAllAtractionsByType(CompanyRepository attractionRepository);
    
    void setAttractionRepositoryStrategy(CompanyRepository attractionRepository);
    
   // List<Attraction> getAllPlanetariums();
    
}
