
package com.copernicana.tripregistry.repository;

import com.copernicana.tripregistry.model.trip.attraction.Beer;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends AttractionRepository<Beer> {
    
}
