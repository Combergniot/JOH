package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.service.GratkaService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
public class GratkaDataCollector extends DataCollectorSettings {

    @Autowired
    GratkaService gratkaService;

    private static final Logger log = LoggerFactory.getLogger(GratkaDataCollector.class);

    /**
     * Collects links to all websites with offers from the portal "gratka.pl".
     */
    public void collectStructure() throws Exception {
        log.info("The page structure is being downloaded...");
        paginationList.add("https://gratka.pl/praca");
        for (int i = 0; i < paginationList.size(); i++) {
            Document paginationPage = Jsoup.connect(paginationList.get(i))
                        .proxy("10.51.55.34", 8080)
                        .userAgent(USER_AGENT)
                        .referrer(REFERRER)
                        .timeout(12000)
                        .ignoreHttpErrors(true)
                        .followRedirects(true)
                        .get();
            Elements pagination = paginationPage.select("a.pagination__nextPage");
            String url = pagination.attr("abs:href");
            paginationList.add(url);
            log.info(paginationList.get(i));
        }
        paginationList.removeAll(Arrays.asList("", null));
        log.info("Page structure downloaded!");
       }

    /**
     * Collects links to all single offers from the portal "gratka.pl".
     */
    public void collectLinks() throws Exception {
        log.info("The links to job offers are being downloaded...");
        for (int i = 0; i < paginationList.size(); i++) {
            Document linkCollection = Jsoup.connect(paginationList.get(i))
                    .proxy("10.51.55.34", 8080)
                    .userAgent(USER_AGENT)
                    .referrer(REFERRER)
                    .timeout(12000)
                    .followRedirects(true)
                    .get();

            Element content = linkCollection.getElementById("leftColumn");
            Elements url = content.select("a.teaser");
            for (Element element : url) {
                String link = element.attr("abs:href");
                jobOffersList.add(link);
            }
            log.info(jobOffersList.get(i));
        }

        log.info("Links to all job offers has been downloaded!");
    }

    /**
     * Collects data from all single job offer from the portal "gratka.pl".
     */

//    public void collectData() throws Exception {
//        log.info("The data downloading is in progress...");
//        for (int i = 0; i < jobOffersList.size(); i++) {
//            Document singleOffer = Jsoup.connect(jobOffersList.get(i))
//                    .proxy("10.51.55.34", 8080)
//                    .userAgent(USER_AGENT)
//                    .referrer(REFERRER)
//                    .timeout(12000)
//                    .ignoreHttpErrors(true)
//                    .followRedirects(true)
//                    .get();
//            Elements jobOfferURL = singleOffer.select("section#info-ogolne");
//
//            for (Element element : jobOfferURL) {
//                Gratka gratka = new Gratka();
//                gratka.setPosition(element.select("header").text());
//
//
//                gratka.setDataSearch(LocalDateTime.now().format(formatter));
//                gratkaService.save(gratka);
//                log.info("The data from single offer was downloaded...");
//            }
//        }
//        log.info("All data from the praca.gratka.pl has been downloaded");
//    }
//
//    public void downloadAll() throws Exception {
//        collectStructure();
//        collectLinks();
//        collectData();
//    }



}

