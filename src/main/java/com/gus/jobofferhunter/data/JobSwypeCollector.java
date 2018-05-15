package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.model.offer.JobSwype;
import com.gus.jobofferhunter.service.JobsPlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Będzie z 1,5tys. ofert - ograniczenie paginacji
@Component
public class JobSwypeCollector extends DataCollectorSettings {

    @Autowired
    JobsPlService jobsPlService;

    private static final Logger log = LoggerFactory.getLogger(JobSwype.class);
}
