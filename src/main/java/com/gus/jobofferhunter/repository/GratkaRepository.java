package com.gus.jobofferhunter.repository;

import com.gus.jobofferhunter.model.offer.JobOffer_Gratka;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GratkaRepository extends CrudRepository<JobOffer_Gratka, Long>{
}
