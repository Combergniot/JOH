package com.gus.jobofferhunter.service;

import com.gus.jobofferhunter.model.JobOffer;
import com.gus.jobofferhunter.repository.JobOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobOfferServiceImpl implements JobOfferService{

    @Autowired
    JobOfferRepository jobOfferRepository;

    @Transactional
    @Override
    public Iterable<JobOffer> getAllJobOffers() {
        return jobOfferRepository.findAll();
    }
}
