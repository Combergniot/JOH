package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.model.offer.AllTheJobs;
import com.gus.jobofferhunter.service.AllTheJobsService;
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
import java.util.List;

@Component
public class AllTheJobsCollector extends DataCollectorSettings {

    @Autowired
    AllTheJobsService allTheJobsService;

    private static final Logger log = LoggerFactory.getLogger(AllTheJobsCollector.class);

    private String findLastPaginationNumber() throws Exception {
        Document paginationPage = Jsoup.connect("https://allthejobs.pl/praca/,p1")
                .proxy("10.51.55.34", 8080)
                .userAgent(USER_AGENT)
                .referrer(REFERRER)
                .timeout(12000)
                .followRedirects(true)
                .get();

        Elements pagination = paginationPage
                .select("div.pull-right");
        String lastPaginationNumber = pagination.select("a.btn.bg-primary").last().text();
//        System.out.println(lastPaginationNumber);
        return lastPaginationNumber;
    }

    private void fillPaginationList() throws Exception {
        int lastPaginationNumber = Integer.parseInt(findLastPaginationNumber());
        for (int i = 1; i <= lastPaginationNumber; i++) {
            paginationList.add("https://allthejobs.pl/praca/,p" + i);
        }
//        System.out.println(paginationList.toString());
    }

    public void collectLinks() throws Exception {
        fillPaginationList();
        for (int i = 0; i < paginationList.size(); i++) {
            Document linkCollection = Jsoup.connect(paginationList.get(i))
                    .proxy("10.51.55.34", 8080)
                    .userAgent(USER_AGENT)
                    .referrer(REFERRER)
                    .timeout(12000)
                    .followRedirects(true)
                    .get();
            Elements content = linkCollection.select("div.module");
            Elements url = content.select("li.relative");
            for (Element element : url) {
                String link = element
                        .select("h3.margin-bottom-clear>a")
                        .attr("abs:href");
                jobOffersList.add(link);
                System.out.println(link);
            }
        }
        removeDuplicatesFromList();
    }


    public void collectData() throws Exception {
        log.info("The data downloading is in progress...");
        for (int i = 0; i < jobOffersList.size(); i++) {
            Thread.sleep(2000 + (long) Math.random() * 2000);
            Document singleOffer = Jsoup.connect(jobOffersList.get(i))
                    .proxy("10.51.55.34", 8080)
                    .userAgent(USER_AGENT)
                    .referrer(REFERRER)
                    .timeout(12000)
                    .followRedirects(false)
                    .get();
            AllTheJobs allTheJobs = new AllTheJobs();
            Elements content = singleOffer.select("div#offer_main_info");
            for (Element element : content) {
                allTheJobs.setPosition(searchForPosition(element));
                allTheJobs.setEmployer(searchForEmployer(element));
                allTheJobs.setWorkplace(searchForWorkplace(element));
                allTheJobs.setDatePublished(searchForDatePublished(element));
                allTheJobs.setUpdateDate(searchForUpdateDate(element));
                allTheJobs.setEmploymentType(searchForEmploymentType(element));
                allTheJobs.setPositionLevel(searchForPositionLevel(element));
                allTheJobs.setSalary(searchForSalary(element));
                allTheJobs.setWebPage(searchForWebPage(element));
                allTheJobs.setOriginalUrl(searchForOriginalUrl(element));
            }
            allTheJobs.setDescription(searchForDescription(singleOffer));
            allTheJobs.setDataSearch(LocalDateTime.now().format(formatter));
            allTheJobs.setUrl(jobOffersList.get(i));
            allTheJobsService.save(allTheJobs);
            log.info("The data from single offer was downloaded...");
        }
        log.info("All data from the allthejobs.pl has been downloaded");
    }

    public void test() throws Exception {
        Document singleOffer = Jsoup.connect("https://allthejobs.pl/praca/specjalista-ds-telefonicznej-rejestracji-szkod-gdansk-pomorskie,464487")
                .proxy("10.51.55.34", 8080)
                .userAgent(USER_AGENT)
                .referrer(REFERRER)
                .timeout(12000)
                .followRedirects(true)
                .get();
        AllTheJobs allTheJobs = new AllTheJobs();
        Elements content = singleOffer.select("div#offer_main_info");
        for (Element element : content) {
            allTheJobs.setPosition(searchForPosition(element));
            allTheJobs.setEmployer(searchForEmployer(element));
            allTheJobs.setWorkplace(searchForWorkplace(element));
            allTheJobs.setDatePublished(searchForDatePublished(element));
            allTheJobs.setUpdateDate(searchForUpdateDate(element));
            allTheJobs.setEmploymentType(searchForEmploymentType(element));
            allTheJobs.setPositionLevel(searchForPositionLevel(element));
            allTheJobs.setSalary(searchForSalary(element));
            allTheJobs.setWebPage(searchForWebPage(element));
            allTheJobs.setOriginalUrl(searchForOriginalUrl(element));
        }
        allTheJobs.setDescription(searchForDescription(singleOffer));
        allTheJobs.setDataSearch(LocalDateTime.now().format(formatter));
        allTheJobs.setUrl("AllTheJobs");
        allTheJobsService.save(allTheJobs);
    }

    public void downloadAll() throws Exception {
        collectLinks();
        try {
            collectData();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private String searchForDescription(Document singleOffer) {
        String description = singleOffer.select("div#offer_description").text();
        return description;
    }

    private String searchForOriginalUrl(Element element) {
        String originalUrl = element.select("a#offer_application").attr("href");
        return originalUrl;
    }

    private String searchForWebPage(Element element) {
        String webPage = element.select("span.offer_secondary")
                .last()
                .text();
        return webPage;
    }

    private String searchForSalary(Element element) {
        String salary = element.select("span[itemprop = baseSalary]").text();
        return salary;

    }

    private String searchForPositionLevel(Element element) {
        String positionLevel =
                element.getElementsContainingOwnText("Poziom stanowiska:")
                        .nextAll("span")
                        .text();
        return positionLevel;
    }

    private String searchForEmploymentType(Element element) {
        String employmentType = element.select("span[itemprop = employmentType]").text();
        return employmentType;
    }

    private String searchForUpdateDate(Element element) {
        String updateDate = element.select("span[itemprop = datePosted]").last().text();
        return updateDate;
    }

    private String searchForDatePublished(Element element) {
        String datePublished = element.select("span[itemprop = datePosted]").first().text();
        return datePublished;
    }

    private String searchForWorkplace(Element element) {
        String workplace = element.select("h2[itemprop = joblocation]").text();
        return workplace;
    }

    private String searchForEmployer(Element element) {
        String employer = element.select("h2[itemprop = hiringOrganization]").text();
        return employer;
    }

    private String searchForPosition(Element element) {
        String position = element.select("h1[itemprop = title]").text();
        return position;
    }

}





