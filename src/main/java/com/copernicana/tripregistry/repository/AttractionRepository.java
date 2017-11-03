package com.copernicana.tripregistry.repository;

import com.copernicana.tripregistry.model.trip.attraction.Attraction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface AttractionRepository<T extends Attraction> extends CrudRepository <T, Long> {
    
    
  //  @Query("select a from Attraction a where a.TYP_ATRAKCJI = :attractionType")
   // public <List> Attraction getAttractionByType(@Param("TYP_ATRAKCJI") String attractionType);
    
    
 
    
}