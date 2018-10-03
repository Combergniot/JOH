package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.model.offer.Olx;
import com.gus.jobofferhunter.service.OlxService;
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
public class OlxDataCollector extends DataCollectorSettings {

    @Autowired
    OlxService olxService;

    private static final Logger log = LoggerFactory.getLogger(OlxDataCollector.class);

    /**
     * Collects links to all websites with offers from the portal "olx.pl".
     */
    public void collectStructure() throws Exception {
        log.info("The page structure is being downloaded...");
        paginationList.add("https://www.olx.pl/praca/");
        for (int i = 0; i < paginationList.size(); i++) {
            Document paginationPage = Jsoup.connect(paginationList.get(i))
                    .proxy("10.51.55.34", 8080)
                    .userAgent(USER_AGENT)
                    .referrer(REFERRER)
                    .timeout(12000)
                    .get();
            Elements pagination = paginationPage.select("span.fbold.next.abs.large>a.link");
            for (Element e : pagination) {
                String url = e.attr("abs:href");
                paginationList.add(url);
            }
//            System.out.println(paginationList.get(i));
        }

        log.info("Page structure downloaded!");
    }

    /**
     * Collects links to all single offers from the portal "www.olx.pl/praca".
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

            Element content = linkCollection.getElementById("offers_table");
            Elements url = content.select("a.link");
            for (Element element : url) {
                String link = element.attr("href");
                jobOffersList.add(link);
            }
//            System.out.println(jobOffersList.get(i));
        }
        removeDuplicatesFromList();
        log.info("Links to all job offers has been downloaded!");
    }

    /**
     * Collects data from all single job offer from the portal "www.olx.pl/praca".
     */
//    TODO = po cholerę ustawiłem int=1 w pętli?
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

            Olx olx = new Olx();
            Elements titleBox = singleOffer.select("div.offer-titlebox");
            for (Element element : titleBox) {
                olx.setPosition(searchForPosition(element));
                olx.setWorkplace(searchForWorkplace(element));
                olx.setDatePublished(searchForDatePublished(element));
                olx.setHourPublished(searchForHourPublished(element));
                olx.setAdId(searchForAdId(element));
            }
            Elements offersParameter = singleOffer.select("ul.offer-parameters");
            for (Element element : offersParameter) {
                olx.setFormOfEmployment(searchForFormOfEmployment(element));
                olx.setContractType(searchForContractType(element));
                olx.setRequired(searchForRequired(element));
                olx.setManagerialPosition(searchForManagerialPosition(element));
            }
            olx.setBranch(searchForBranch(singleOffer));
            olx.setDescription(searchForDescription(singleOffer));
            olx.setSalary(searchForSalary(singleOffer));
            olx.setEmployer(searchForEmployer(singleOffer));
            olx.setWebPage("olx.pl");
            olx.setDataSearch(LocalDateTime.now().format(formatter));
            olx.setUrl(jobOffersList.get(i));
            olxService.save(olx);
            log.info("The data from single offer was downloaded...");
        }
        log.info("All data from the Olx.pl has been downloaded");
    }

    public void test() throws Exception {
        log.info("The data downloading is in progress...");
        Document singleOffer = Jsoup.connect("https://www.olx.pl/oferta/kierownik-zmiany-CID4-IDrJtmP.html#e883c731b3")
                .proxy("10.51.55.34", 8080)
                .userAgent(USER_AGENT)
                .referrer(REFERRER)
                .timeout(12000)
                .ignoreHttpErrors(true)
                .followRedirects(true)
                .get();

        Olx olx = new Olx();
        Elements titleBox = singleOffer.select("div.offer-titlebox");
        for (Element element : titleBox) {
            olx.setPosition(searchForPosition(element));
            olx.setWorkplace(searchForWorkplace(element));
            olx.setDatePublished(searchForDatePublished(element));
            olx.setHourPublished(searchForHourPublished(element));
            olx.setAdId(searchForAdId(element));
           }
        Elements offersParameter = singleOffer.select("ul.offer-parameters");
        for (Element element : offersParameter) {
            olx.setFormOfEmployment(searchForFormOfEmployment(element));
            olx.setContractType(searchForContractType(element));
            olx.setRequired(searchForRequired(element));
            olx.setManagerialPosition(searchForManagerialPosition(element));
        }
        olx.setBranch(searchForBranch(singleOffer));
        olx.setDescription(searchForDescription(singleOffer));
        olx.setSalary(searchForSalary(singleOffer));
        olx.setEmployer(searchForEmployer(singleOffer));
        olx.setWebPage("olx.pl");
        olx.setDataSearch(LocalDateTime.now().format(formatter));
        olxService.save(olx);
        log.info("The data from single offer was downloaded...");
    }

    public void downloadAll() throws Exception{
        collectStructure();
        collectLinks();
        collectData();
    }

    /**
     * Path to values from single job offer.
     */
    private String searchForSalary(Document singleOffer) {
        String salary = singleOffer.select("div.price-label").text();
        return salary;
    }

    private String searchForDescription(Document singleOffer) {
        String description = singleOffer.select("div#textContent").text();
        return description;
    }

    private String searchForBranch(Document singleOffer) {
        String branch = singleOffer.select("li.inline").next().next().text();
        return branch;
    }

    private String searchForEmployer(Document singleOffer) {
        String advertiser =
                singleOffer.select("div.offer-user__details >h4").text();
        return advertiser;
    }

    private String searchForPosition (Element element){
        String position = element.select("h1").text();
        return position;
    }

    private String searchForWorkplace (Element element){
        String workplace = element.select("strong").text();
        return workplace;
    }

    private String searchForDatePublished (Element element){
        String dateInfoBox = element.select("em").text();
        String datePublished = dateInfoBox.substring(dateInfoBox.indexOf(",") +2, dateInfoBox.length()-26);
        return  datePublished;
   }

   private String searchForHourPublished (Element element){
       try {
           String dateInfoBox = element.select("em").text();
           String hourPublished = dateInfoBox.substring(9,dateInfoBox.indexOf(","));
           return  hourPublished;
       } catch (Exception e) {
           e.printStackTrace();
           return "Do poprawki";
       }
   }

    private String searchForAdId (Element element){
        String idBox = element.select("em>small").text();
        String adId = idBox.substring(15);
        return adId;
    }

    private String searchForFormOfEmployment(Element element) {
        String formOfEmployment =
                element.select("strong").first().text();
        return formOfEmployment;
    }

    private String searchForContractType(Element element) {
        String contractType =
                element.getElementsContainingOwnText("Typ umowy:").select("strong").text();
        return contractType;
    }

    private String searchForRequired(Element element) {
        String required =
                element.getElementsContainingOwnText("Wymagane:").select("strong").text();
        return required;
    }

    private String searchForManagerialPosition(Element element) {
        String managerialPositon =
                element.getElementsContainingOwnText("Kadra kierownicza:").select("strong").text();
        return managerialPositon;
    }


}






