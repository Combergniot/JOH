package com.gus.jobofferhunter.repository;

import com.gus.jobofferhunter.model.offer.JobOffer_GoldenLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoldenLineRepository extends CrudRepository <JobOffer_GoldenLine, Long> {
}
