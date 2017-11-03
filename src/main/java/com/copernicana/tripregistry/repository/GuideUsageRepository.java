
package com.copernicana.tripregistry.repository;

import com.copernicana.tripregistry.model.trip.guideusage.GuideUsage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideUsageRepository extends CrudRepository <GuideUsage, Long> {
    
}
