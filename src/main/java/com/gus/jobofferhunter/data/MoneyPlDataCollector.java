package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.model.offer.MoneyPl;
import com.gus.jobofferhunter.service.MoneyPlService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MoneyPlDataCollector extends DataCollectorSettings {

    @Autowired
    MoneyPlService moneyPlService;

    private static final Logger log = LoggerFactory.getLogger(MoneyPlDataCollector.class);

    /**
     * Collects links to all websites with offers from the portal "praca.money.pl".
     */
    public void collectStructure() throws Exception {
        log.info("The page structure is being downloaded...");
        paginationList.add("https://praca.money.pl/oferty,pracy,wyszukaj,0.html?slowo=&zawod=&wojewodztwo=&okres=");
        for (int i = 0; i < paginationList.size(); i++) {
            Document paginationPage = Jsoup.connect(paginationList.get(i))
                    .proxy("10.51.55.34", 8080)
                    .userAgent(USER_AGENT)
                    .referrer(REFERRER)
                    .timeout(12000)
                    .ignoreHttpErrors(true)
                    .followRedirects(true)
                    .get();
            Elements pagination = paginationPage.select("a.next");
            for (Element e : pagination) {
                String url = e.attr("abs:href");
                paginationList.add(url);
            }
            System.out.println(paginationList.get(i));
        }
        log.info("Page structure downloaded!");
    }

    /**
     * Collects basic data from all single job offer from the portal "praca.money.pl".
     */
    public void collectData() throws Exception {
        log.info("The data downloading is in progress...");
        for (int i = 0; i < paginationList.size(); i++) {
            Document singleOffer = Jsoup.connect(paginationList.get(i))
                    .proxy("10.51.55.34", 8080)
                    .userAgent(USER_AGENT)
                    .referrer(REFERRER)
                    .timeout(12000)
                    .ignoreHttpErrors(true)
                    .followRedirects(true)
                    .get();
            Elements jobOfferTable = singleOffer.select("table.lista-ofert");
            Elements singleOfferBox = jobOfferTable.select("tr");
            for (Element element : singleOfferBox) {
                MoneyPl moneyPl = new MoneyPl();
                moneyPl.setPosition(searchForPosition(element));
                moneyPl.setEmployer(searchForEmployer(element));
                moneyPl.setDatePublished(searchForDatePublished(element));
                moneyPl.setWorkplace(searchForWorkplace(element));
                moneyPl.setWebPage(searchForWebPage(element));
                moneyPl.setDataSearch(LocalDateTime.now().format(formatter));
                moneyPlService.save(moneyPl);
//            System.out.println(moneyPl.toString());
                log.info("The data from single offer was downloaded...");
            }
            log.info("All data from the Money.pl has been downloaded");
        }
    }

    public void downloadALL() throws Exception{
        collectStructure();
        collectData();
    }


    /**
     * Path to values from single job offer.
     */
    private String searchForPosition(Element element){
        String position
                = element.select("span.oferta").text();
        return position;
    }

    private String searchForEmployer(Element element){
        String employer
                = element.select("span.firma").text();
        return employer;
    }

    private String searchForDatePublished (Element element){
        String datePublished =
                element.select("span.data").text();
        return datePublished;
    }

    private String searchForWorkplace (Element element){
        String workplace =
                element.select("span.city").text();
        return workplace;
    }

    private String searchForWebPage (Element element){
        String webPage =
                element.getElementsByTag("img").attr("alt");
        return webPage;
    }

}

