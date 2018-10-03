package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.model.offer.Gratka;
import com.gus.jobofferhunter.service.GratkaService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

//TODO Ze skryptu mozna wyodrębnic samą nazwę miejscowosc, forme zatrudnienia i ID oferty.
// Datę publikacji by trzeba razem z linkiem pobierac, jako hashmapę

@Component
public class GratkaDataCollector extends DataCollectorSettings {

    @Autowired
    GratkaService gratkaService;

    private static final Logger log = LoggerFactory.getLogger(GratkaDataCollector.class);

    //TODO - split może powodować błedy
    private String findLastPaginationNumber() throws Exception {
        Document paginationPage = Jsoup.connect("https://gratka.pl/praca")
                .proxy("10.51.55.34", 8080)
                .userAgent(USER_AGENT)
                .referrer(REFERRER)
                .timeout(12000)
                .followRedirects(true)
                .get();

        Elements pagination = paginationPage
                .select("div.pagination");
        String lastPaginationNumber = pagination.select("span.pagination__separator").next().text();
        String lastNumber = lastPaginationNumber.substring(0, lastPaginationNumber.length() - 4);
        return lastNumber;

    }


    private void fillPaginationList() throws Exception {
        int lastPaginationNumber = Integer.parseInt(findLastPaginationNumber());
        for (int i = 1; i <= lastPaginationNumber; i++) {
            paginationList.add("https://gratka.pl/praca?page=" + i);
        }
//        System.out.println(paginationList.toString());
    }

    /**
     * Collects links to all websites with offers from the portal "gratka.pl".
     */
    private void collectStructure() throws Exception {
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
        fillPaginationList();
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
//            Elements datePosted = content.select("ul.teaser__info");
            for (Element element : url) {
                String link = element.attr("abs:href");
                jobOffersList.add(link);
                System.out.println(link);
            }
        }
//        TODO - oficjalnie 13162, zostało 9996. Sprawdzic czy to nie zbyt restrykcyjne podejscie
        removeDuplicatesFromList();
        log.info("Links to all job offers has been downloaded!");
    }

    /**
     * Collects data from all single job offer from the portal "gratka.pl".
     */
    public void collectData() throws Exception {
        log.info("The data downloading is in progress...");
        for (int i = 0; i < jobOffersList.size(); i++) {
            Document singleOffer = Jsoup.connect(jobOffersList.get(i))
                    .proxy("10.51.55.34", 8080)
                    .userAgent(USER_AGENT)
                    .referrer(REFERRER)
                    .timeout(12000)
                    .ignoreHttpErrors(true)
                    .followRedirects(true)
                    .get();
            Elements mainTable = singleOffer.select("div#rightColumn");
            Gratka gratka = new Gratka();
            for (Element element : mainTable) {
                gratka.setPosition(searchForPosition(element));
                gratka.setSalary(searchForSalary(element));
            }
            Elements parameters = mainTable.select("div.parameters");
            for (Element element : parameters) {
                gratka.setWorkplace(searchForWorkplace(element));
                gratka.setEmployer(searchForEmployer(element));
                gratka.setTypeOfWork(searchForTypeOfWork(element));
                gratka.setPositionLevel(searchForPositionLevel(element));
                gratka.setAdditionalOptions(searchForAdditionalOptions(element));
            }
            gratka.setDescription(searchForDescription(singleOffer));
            gratka.setBranch(searchForBranch(singleOffer));
            gratka.setWebPage("gratka.pl");
            gratka.setDataSearch(LocalDateTime.now().format(formatter));
            gratka.setUrl(jobOffersList.get(i));
            gratkaService.save(gratka);
            log.info("The data from single offer was downloaded...");
        }
    }

    public void test() throws Exception {
        Document singleOffer = Jsoup.connect("https://gratka.pl/praca/frezer-cnc-wynagrodzenie-nawet-5500-zl/ob/3671707")
                .proxy("10.51.55.34", 8080)
                .userAgent(USER_AGENT)
                .referrer(REFERRER)
                .timeout(12000)
                .ignoreHttpErrors(true)
                .followRedirects(true)
                .get();
        Elements mainTable = singleOffer.select("div#rightColumn");
        Gratka gratka = new Gratka();
        for (Element element : mainTable) {
            gratka.setPosition(searchForPosition(element));
            gratka.setSalary(searchForSalary(element));
        }
        Elements parameters = mainTable.select("div.parameters");
        for (Element element : parameters) {
            gratka.setWorkplace(searchForWorkplace(element));
            gratka.setEmployer(searchForEmployer(element));
            gratka.setTypeOfWork(searchForTypeOfWork(element));
            gratka.setPositionLevel(searchForPositionLevel(element));
            gratka.setAdditionalOptions(searchForAdditionalOptions(element));
        }
        gratka.setDescription(searchForDescription(singleOffer));
        gratka.setBranch(searchForBranch(singleOffer));
        gratka.setWebPage("gratka.pl");
        gratka.setDataSearch(LocalDateTime.now().format(formatter));
        gratkaService.save(gratka);
        log.info("The data from single offer was downloaded...");
    }

    private String searchForAdditionalOptions(Element element) {
        try {
            String additionalOptions =
                    element.getElementsContainingOwnText("Dodatkowe opcje").next().text();
            return additionalOptions;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return "";
        }
    }

    private String searchForDescription(Document singleOffer) {
        String description = singleOffer.select("div.description__container").text();
        return description;
    }

    private String searchForBranch(Document singleOffer) {
        try {
            String branch =
                    singleOffer.select("ul.breadcrumb__list > li").last().text();
            return branch;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return "brak danych";
        }
    }

    private String searchForPositionLevel(Element element) {
        String positionLevel =
                element.getElementsContainingOwnText("Poziom stanowiska").next().text();
        return positionLevel;
    }

    private String searchForTypeOfWork(Element element) {
        String typeOfWork =
                element.getElementsContainingOwnText("Rodzaj pracy").next().text();
        return typeOfWork;
    }

    private String searchForEmployer(Element element) {
        String employer =
                element.getElementsContainingOwnText("Nazwa firmy").next().text();
        return employer;
    }

    private String searchForWorkplace(Element element) {
        String workplace =
                element.getElementsContainingOwnText("Region").next().text();
        return workplace;
    }

    private String searchForSalary(Element element) {
        String salary = element.select("p.sticker__price").text();
        return salary;
    }

    private String searchForPosition(Element element) {
        String title = element.select("h1.sticker__title").text();
        return title;
    }

    public void downloadAll() throws Exception {
        collectLinks();
        collectData();
    }


}

