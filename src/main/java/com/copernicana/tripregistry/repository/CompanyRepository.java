package com.copernicana.tripregistry.repository;

import com.copernicana.tripregistry.model.trip.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository<T extends Company> extends CrudRepository <T, Long> {
    
    
  //  @Query("select a from Attraction a where a.TYP_ATRAKCJI = :attractionType")
   // public <List> Attraction getAttractionByType(@Param("TYP_ATRAKCJI") String attractionType);
    
    
 
    
}
