package com.gus.jobofferhunter.service;

import com.gus.jobofferhunter.model.JobOffer;

public interface JobOfferService {

    Iterable<JobOffer> getAllJobOffers();

  //  List<JobOffer> getAllJobOffersByBranch(JobOfferRepository jobOfferRepository);

}
