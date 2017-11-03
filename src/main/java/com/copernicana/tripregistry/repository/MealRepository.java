
package com.copernicana.tripregistry.repository;

import com.copernicana.tripregistry.model.trip.Meal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends CrudRepository <Meal, Long> {
    
}
