//package com.gus.jobofferhunter.data;
//
//import com.gus.jobofferhunter.model.offer.Gratka;
//import com.gus.jobofferhunter.service.GratkaService;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//import java.util.List;
//

//
//@Component
//public class GratkaDataCollector extends DataCollectorSettings {
//
//    @Autowired
//    GratkaService gratkaService;
//
//    private static final Logger log = LoggerFactory.getLogger(GratkaDataCollector.class);
//
//    /**
//     * Collects links to all websites with offers from the portal "praca.gratka.pl".
//     */
//    public void collectStructure() throws Exception {
//        log.info("The page structure is being downloaded...");
//        paginationList.add("http://praca.gratka.pl/lista/");
//        for (int i = 0; i < paginationList.size(); i++) {
//            Document paginationPage = Jsoup.connect(paginationList.get(i))
//                    .proxy("10.51.55.34", 8080)
//                    .userAgent(USER_AGENT)
//                    .referrer(REFERRER)
//                    .timeout(12000)
//                    .followRedirects(true)
//                    .get();
//            Elements pagination = paginationPage.select(".dol >li >a.stronaNastepna");
//            for (Element e : pagination) {
//                String url = e.attr("abs:href");
//                paginationList.add(url);
//            }
////                        System.out.println(paginationList.get(i));
//        }
//        log.info("Page structure downloaded!");
//    }
//
//    /**
//     * Collects links to all single offers from the portal "praca.gratka.pl".
//     */
//    public void collectLinks() throws Exception {
//        log.info("The links to job offers are being downloaded...");
//        for (int i = 0; i < paginationList.size(); i++) {
//            Document linkCollections = Jsoup.connect(paginationList.get(i))
//                    .proxy("10.51.55.34", 8080)
//                    .userAgent(USER_AGENT)
//                    .referrer(REFERRER)
//                    .timeout(12000)
//                    .followRedirects(true)
//                    .get();
//
//            Element content = linkCollections.getElementById("wyniki-wyszukiwania");
//            Elements url = content.select("a.stanowisko");
//            for (Element element : url) {
//                String link = element.attr("href");
//                jobOffersList.add("http://praca.gratka.pl" + link);
//            }
////          System.out.println(jobOffersList.get(i));
//        }
//        removeDuplicatesFromList();
//        log.info("Links to all job offers has been downloaded!");
//    }
//
//    /**
//     * Collects data from all single job offer from the portal "praca.gratka.pl".
//     */
//
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
//            Elements alterantive = singleOffer.select("article#ogloszenie-praca");
//            for (Element element : jobOfferURL) {
//                Gratka gratka = new Gratka();
//                gratka.setPosition(element.select("header").text());
//                if (gratka.getPosition().isEmpty()) {
//                    gratka.setPosition(alterantive.select("h1").text());
//                }
//                gratka.setDateAdded(searchForDateAdded(element));
//                gratka.setCountry(searchForCountry(element));
//                gratka.setProvince(searchForProvince(element));
//                gratka.setWorkplace(searchForWorkplace(element));
//                gratka.setEmployer(searchForEmployer(element));
//                gratka.setBranch(searchForBranch(element));
//                gratka.setPositionLevel(searchForJobType(element));
//                gratka.setTypeOfWork(searchForTypeOfWork(element));
//                gratka.setContractType(searchForFormOfEmployment(element));
//                gratka.setRequiredEducation(searchForRequiredEducation(element));
//                gratka.setSalary(searchForSalary(element));
//                gratka.setOfferFromNewspapper(searchForOfferFromNewspapper(element));
//                gratka.setAdditionalOptions(searchForAdditionalOptions(element));
//                gratka.setUrl(jobOffersList.get(i));
//                gratka.setDataSearch(LocalDateTime.now().format(formatter));
//                gratkaService.save(gratka);
//                log.info("The data from single offer was downloaded...");
//            }
//        }
//        log.info("All data from the praca.gratka.pl has been downloaded");
//    }
//
//    public void downloadAll() throws Exception{
//        collectStructure();
//        collectLinks();
//        collectData();
//    }
//
//    /**
//     * Path to values from single job offer.
//     */
//
//    private String searchForDateAdded (Element element){
//        String dateAdded =
//                element.getElementsContainingOwnText("Data ogłoszenia").next().text();
//        return dateAdded;
//    }
//
//    private String searchForCountry (Element element) {
//        String country =
//                element.getElementsContainingOwnText("Kraj").next().text();
//        return country;
//    }
//
//    private String searchForProvince (Element element) {
//        String province =
//                element.getElementsContainingOwnText("Region").next().text();
//        return province;
//    }
//
//    private String searchForWorkplace (Element element){
//        String workplace =
//                element.getElementsContainingOwnText("Lokalizacja").next().text();
//        return workplace;
//    }
//
//    private String searchForEmployer (Element element){
//        String employer =
//                element.getElementsContainingOwnText("Pracodawca").next().text();
//        return employer;
//    }
//
//    private String searchForBranch (Element element){
//        String branch =
//                element.getElementsContainingOwnText("Branża").next().text();
//        return branch;
//    }
//
//    private String searchForJobType (Element element){
//        String jobType =
//                element.getElementsContainingOwnText("Typ stanowiska").next().text();
//        return jobType;
//    }
//
//    private String searchForTypeOfWork (Element element){
//        String typeOfWork =
//                element.getElementsContainingOwnText("Rodzaj pracy").next().text();
//        return typeOfWork;
//    }
//
//    private String searchForFormOfEmployment (Element element){
//        String formOfEmployment =
//                element.getElementsContainingOwnText("Forma zatrudnienia").next().text();
//        return formOfEmployment;
//    }
//
//    private String searchForRequiredEducation (Element element){
//        String requiredEducation =
//                element.getElementsContainingOwnText("Minimalne wykształcenie")
//                        .next().text();
//        return requiredEducation;
//    }
//
//    private String searchForSalary (Element element){
//        String salary =
//                element.getElementsContainingOwnText("Wynagrodzenie")
//                        .next().text();
//        return salary;
//    }
//
//    private String searchForOfferFromNewspapper (Element element) {
//        String offerFromNewspapper =
//                element.getElementsByTag("img").attr("alt");
//        return  offerFromNewspapper;
//    }
//
//    private String searchForAdditionalOptions (Element element){
//        String additionalOptions =
//                element.getElementsContainingOwnText("Opcje dodatkowe").next().text();
//        return additionalOptions;
//    }
//
//    private List removeDuplicatesFromList(){
//        paginationSet.addAll(jobOffersList);
//        jobOffersList.clear();
//        jobOffersList.addAll(paginationSet);
//        return jobOffersList;
//    }
//
//}
//
