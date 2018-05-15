package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.model.offer.CareerJet;
import com.gus.jobofferhunter.service.CareerJetService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Pobierze tylko z 2tys. ofert... 100*20
@Component
public class CareerJetCollector extends DataCollectorSettings{

    @Autowired
    CareerJetService careerJetService;

    private static final Logger log = LoggerFactory.getLogger(CareerJet.class);

    /**
     * Collects links to all websites with offers from the portal "careerjet.pl".
     */
    public void collectStructure() throws Exception {
        log.info("The page structure is being downloaded...");
        paginationList.add("https://www.careerjet.pl/szukaj/oferty_pracy?s=&l=");
        for (int i = 0; i < paginationList.size(); i++) {
            Document paginationPage = Jsoup.connect(paginationList.get(i))
                    .proxy("10.51.55.34", 8080)
                    .userAgent(USER_AGENT)
                    .referrer(REFERRER)
                    .timeout(12000)
                    .followRedirects(true)
                    .get();
            Element pagination = paginationPage
                    .select("p.browse.new_browse >a").last();
                String url = pagination.attr("abs:href");
                paginationList.add(url);
                System.out.println(paginationList.get(i));
        }
        log.info("Page structure downloaded!");
    }
}

