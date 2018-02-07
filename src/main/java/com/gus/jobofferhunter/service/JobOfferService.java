package com.gus.jobofferhunter.service;

import com.gus.jobofferhunter.model.JobOffer;
import org.springframework.stereotype.Service;

@Service
public interface JobOfferService {

    Iterable<JobOffer> getAllJobOffers();

  //  List<JobOffer> getAllJobOffersByBranch(JobOfferRepository jobOfferRepository);

}
