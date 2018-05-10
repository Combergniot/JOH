package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.model.offer.LinguaJob;
import com.gus.jobofferhunter.service.LinguaJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LinguaJobCollector extends DataCollectorSettings {

    @Autowired
    LinguaJobService linguaJobService;

    private static final Logger log = LoggerFactory.getLogger(LinguaJob.class);
}
