package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.model.offer.CareerJet;
import com.gus.jobofferhunter.service.CareerJetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CareerJetCollector extends DataCollectorSettings{

    @Autowired
    CareerJetService careerJetService;

    private static final Logger log = LoggerFactory.getLogger(CareerJet.class);
}

