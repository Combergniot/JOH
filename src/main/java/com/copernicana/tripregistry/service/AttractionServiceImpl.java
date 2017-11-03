package com.copernicana.tripregistry.service;

import com.copernicana.tripregistry.model.trip.attraction.Attraction;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.copernicana.tripregistry.repository.CompanyRepository;

@Service
public class AttractionServiceImpl implements AttractionService {

    private CompanyRepository attractionRepositoryStrategy;

    public void setAttractionRepositoryStrategy(CompanyRepository attractionRepositoryStrategy) {
        this.attractionRepositoryStrategy = attractionRepositoryStrategy;
    }

    @Override
    public List<Attraction> getAllAttractions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public List<Attraction> getAllAtractionsByType(CompanyRepository attractionRepository) {
        setAttractionRepositoryStrategy(attractionRepository);
        return (List<Attraction>) attractionRepositoryStrategy.findAll();
    }

}
