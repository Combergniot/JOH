
package com.copernicana.tripregistry.repository;

import com.copernicana.tripregistry.model.trip.guideusage.Sightseeing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SightseeingRepository extends CrudRepository <Sightseeing, Long> {
    
}
