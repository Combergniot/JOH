package com.copernicana.tripregistry.repository;

import com.copernicana.tripregistry.model.trip.attraction.Cruise;
import org.springframework.stereotype.Repository;

@Repository
public interface CruiseRepository extends AttractionRepository<Cruise>{
}
