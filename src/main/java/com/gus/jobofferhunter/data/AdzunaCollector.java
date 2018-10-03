package com.gus.jobofferhunter.data;

//https://developer.adzuna.com/overview
//

import com.gus.jobofferhunter.api.AdzunaApiService;
import com.gus.jobofferhunter.model.offer.Adzuna;
import com.gus.jobofferhunter.model.offer.MoneyPl;
import com.gus.jobofferhunter.service.AdzunaService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;


//TODO - pobieranie całości ofert przez API?
//Pobierać dane z innych krajow

@Component
public class AdzunaCollector extends DataCollectorSettings {

    private static final Logger log = LoggerFactory.getLogger(AdzunaCollector.class);
    AdzunaApiService adzunaApiService = new AdzunaApiService();
    @Autowired
    AdzunaService adzunaService;

    public void getSampleResponse() {
        try {
            Document paginationPage = Jsoup.connect(
                    "http://api.adzuna.com/v1/api/jobs/pl/search/" +
                            "1" +
                            "?app_id=" + adzunaApiService.getApplicationId() +
                            "&app_key=" + adzunaApiService.getApplicationKey() +
                            "&results_per_page=1&content-type=text")
                    .proxy("10.51.55.34", 8080)
                    .userAgent(USER_AGENT)
                    .referrer(REFERRER)
                    .timeout(12000)
                    .followRedirects(true)
                    .get();
            String content = paginationPage.text();
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getCategories() throws IOException {
        Document paginationPage = Jsoup.connect(
                "http://api.adzuna.com/v1/api/jobs/pl/" +
                        "categories" +
                        "?app_id=" + adzunaApiService.getApplicationId() +
                        "&app_key=" + adzunaApiService.getApplicationKey() +
                        "&&content-type=text")
                .proxy("10.51.55.34", 8080)
                .userAgent(USER_AGENT)
                .referrer(REFERRER)
                .timeout(12000)
                .followRedirects(true)
                .get();
        String content = paginationPage.text();
        System.out.println(content);
    }

    private String findLastPaginationNumber() throws Exception {
        Document paginationPage = Jsoup.connect("https://www.adzuna.pl/search?w=Polska")
                .proxy("10.51.55.34", 8080)
                .userAgent(USER_AGENT)
                .referrer(REFERRER)
                .timeout(12000)
                .followRedirects(true)
                .get();

        Elements pagination = paginationPage
                .select("table.pg>tbody>tr>td");
        String lastPaginationNumber = pagination.get(9).text();
        System.out.println(lastPaginationNumber);
        return lastPaginationNumber;
    }

    public void fillPaginationList() throws Exception {
        int lastPaginationNumber = Integer.parseInt(findLastPaginationNumber());
        for (int i = 1; i <= lastPaginationNumber; i++) {
            paginationList.add("https://www.adzuna.pl/search?loc=133355&p=" + i);
        }
        System.out.println(paginationList.toString());
    }

    public void collectData() throws Exception {
        fillPaginationList();
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
            Elements jobOfferTable = singleOffer.select("div.sr");
            Elements singleOfferBox = jobOfferTable.select("div.a");
            for (Element element : singleOfferBox) {
                Adzuna adzuna = new Adzuna();
                adzuna.setPosition(searchForPosition(element));
                adzuna.setEmployer(searchForEmployer(element));
                adzuna.setWorkplace(searchForWorkplace(element));
                adzuna.setUrl(searchForUrl(element));
                adzuna.setSalary(searchForSalary(element));
                adzuna.setDataSearch(LocalDateTime.now().format(formatter));
                adzuna.setWebPage("Adzuna");
                adzunaService.save(adzuna);
                log.info("The data from single offer was downloaded...");
            }
            log.info("All data from the Adzuna has been downloaded");
        }
    }

    private String searchForSalary(Element element) {
        String salary = element.select("p.at>span.at_sl").text();
        return salary;
    }

    private String searchForUrl(Element element) {
        String url = element.select("h2>a").first().attr("abs:href");
        return url;
    }

    private String searchForWorkplace(Element element) {
        String workplace = element.select("p.as>span.loc").text();
        return workplace;
    }

    //not span.loc
    private String searchForEmployer(Element element) {
        String employer = element.select("p.as").text();
        return employer;
    }

    private String searchForPosition(Element element) {
        String position = element.select("h2>a>strong").text();
        return position;
    }


}




