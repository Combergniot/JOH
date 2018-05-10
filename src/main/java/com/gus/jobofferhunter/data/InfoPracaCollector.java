package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.model.offer.InfoPraca;
import com.gus.jobofferhunter.service.InfoPracaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InfoPracaCollector extends DataCollectorSettings {

    @Autowired
    InfoPracaService infoPracaService;

    private static final Logger log = LoggerFactory.getLogger(InfoPraca.class);
}
