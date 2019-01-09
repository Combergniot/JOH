package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.model.offer.PracujPl;
import com.gus.jobofferhunter.service.PracujPlService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PracujPlScrapper extends DataCollectorSettings {

    @Autowired
    PracujPlService pracujPlService;

    private static final Logger log = LoggerFactory.getLogger(PracujPlScrapper.class);

    /**
     * Collects links to all websites with offers from the portal "pracuj.pl".
     */
    public void collectStructure() throws Exception {
        log.info("The page structure is being downloaded...");
        paginationList.add("https://www.pracuj.pl/praca");
        for (int i = 0; i < paginationList.size(); i++) {
            Document paginationPage = connectWith(paginationList.get(i));
            Elements pagination = paginationPage
                    .select("ul.desktopPagin.clearfix >li >a.desktopPagin_item_link:contains(Następna)");
            for (Element e : pagination) {
                String url = e
                        .attr("abs:href");
                paginationList.add(url);
            }
//            System.out.println(paginationList.get(i));
        }
        log.info("Page structure downloaded!");
    }

    private String findLastPaginationNumber() throws Exception {
        Document paginationPage = connectWith("https://www.pracuj.pl/praca");
        Elements pagination = paginationPage
                .select("ul.pagination_list>li>a.pagination_trigger");
        if (pagination.size() > 2) {
            String lastPaginationNumber = pagination.get(3).text();
            System.out.println(lastPaginationNumber);
            return lastPaginationNumber;
        }
        return "";
    }

    private void fillPaginationList() throws Exception {
        int lastPaginationNumber = Integer.parseInt(findLastPaginationNumber());
        for (int i = 1; i <= lastPaginationNumber; i++) {
            paginationList.add("https://www.pracuj.pl/praca?pn=" + i);
        }
//        System.out.println(paginationList.toString());
    }

    // TODO: 2019-01-09 Pobiera tylko po 10 linków, z kazdej podstrony - sprawdz
    /**
     * Collects links to all single offers from the portal "pracuj.pl".
     */
    public void collectLinks() throws Exception {
        log.info("The links to job offers are being downloaded...");
        for (int i = 0; i < paginationList.size(); i++) {
//                Thread.sleep(3000 + (long) Math.random() * 2000);
            Document linkCollection = connectWith(paginationList.get(i));
            Elements content = linkCollection.select("ul.results__list-container");
            Elements url = content.select("" +
                    "li.results__list-container-item>div");
            for (Element element : url) {
                String link = element
//                    .select("div.offer__info>" +
//                            "div.offer-details>" +
//                            "div.offer-details__text>" +
//                            "h3>" +
//                            "a.offer-details__title-link")
                        .select("a.offer-details__title-link")
                        .attr("abs:href");

                if (link != null) {
                    jobOffersList.add(link);
                    log.info(link);
                }
            }
            removeDuplicatesFromList();
            log.info("Links to all job offers from pracuj.pl has been downloaded!");
        }
    }

    /**
     * Collects data from all single job offer from the portal "pracuj.pl".
     */
    public void collectData() throws Exception {
        log.info("The data downloading is in progress...");
        for (int i = 0; i < jobOffersList.size(); i++) {
//                    Thread.sleep(3000 + (long) Math.random() * 2000);
            Document singleOffer = connectWith(jobOffersList.get(i));
            PracujPl pracujPl = new PracujPl();
            Elements applyBox = singleOffer.select("div.apply");
            for (Element element : applyBox) {
                pracujPl.setEmployer(searchForEmployer(element));
                pracujPl.setPosition(searchForPosition(element));
                pracujPl.setWorkplace(searchForLocation(element));
                pracujPl.setEmploymentType(searchForEmploymentType(element));
                pracujPl.setDatePublished(searchForDatePublished(element));
                pracujPl.setValidThrough(searchForValidThrough(element));
                pracujPl.setEmploLink(searchForEmploLink(element));
                pracujPl.setRegion(searchForRegion(element));
            }
            Elements branchParameter = singleOffer.select("div.content");
            for (Element element : branchParameter) {
                pracujPl.setBranch(searchForBranch(element));
                pracujPl.setDataID(searchForDataId(element));
            }
            pracujPl.setUrl(jobOffersList.get(i));
            pracujPl.setDataSearch(LocalDateTime.now().format(formatter));
            pracujPl.setWebPage("pracuj.pl");
            pracujPlService.save(pracujPl);
            log.info("The data from single offer was downloaded...");
        }
        log.info("All data from the pracuj.pl has been downloaded");
    }


    /**
     * Initiates the process of data collection".
     */
    public void downloadAll() throws Exception {
        fillPaginationList();
//        collectStructure();
        collectLinks();
        collectData();
    }

    public void test() throws Exception {
        log.info("The data downloading is in progress...");
        Document singleOffer = connectWith("https://www.pracuj.pl/praca/junior-java-developer-warszawa,oferta,6551031?sug=SG_bd_5");
        PracujPl pracujPl = new PracujPl();
        Elements applyBox = singleOffer.select("div.apply");
        for (Element element : applyBox) {
            pracujPl.setEmployer(searchForEmployer(element));
            pracujPl.setPosition(searchForPosition(element));
            pracujPl.setWorkplace(searchForLocation(element));
            pracujPl.setEmploymentType(searchForEmploymentType(element));
            pracujPl.setDatePublished(searchForDatePublished(element));
            pracujPl.setValidThrough(searchForValidThrough(element));
            pracujPl.setUrl("https://www.pracuj.pl/praca/lider-projektow-six-sigma-lean-wroclaw,oferta,5903764");
            pracujPl.setEmploLink(searchForEmploLink(element));
            pracujPl.setDataSearch(LocalDateTime.now().format(formatter));
            pracujPl.setWebPage("pracuj.pl");
            pracujPl.setRegion(searchForRegion(element));
        }
        Elements branchParameter = singleOffer.select("div.content");
        for (Element element : branchParameter) {
            pracujPl.setBranch(searchForBranch(element));
            pracujPl.setDataID(searchForDataId(element));
        }
        pracujPlService.save(pracujPl);
        log.info("The data from single offer was downloaded...");
    }

    private String searchForRegion(Element element) {
        String workplace = searchForWorkplace(element);
        String region =
                workplace.substring(workplace.lastIndexOf(",") + 1);
        String correctRegion = region.replaceAll("\\s+", "");
        return correctRegion;
    }

    /**
     * Path to values from single job offer.
     */
    private String searchForValidThrough(Element element) {
        String dateInfoBox = element.select("span[itemprop = validThrough]").text();
        try {
            String validThrough = dateInfoBox.substring(0, dateInfoBox.length() - 1);
            return validThrough;
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
            return dateInfoBox;
        }
    }

    //  Błąd w zapisie słowa 'rozwój' na stronie np. Badania i rozwój, IT- rozwój oprogramowania
    private String searchForBranch(Element element) {
        try {
            String script = element.getElementsByTag("script")
                    .first().nextElementSibling().html();
            String branch = script.substring(script.indexOf("=") + 3, script.indexOf(";") - 1);
            String correction = branch.replaceAll("Rozw&#24", "Rozwój oprogramowania");
            String correctBranch = correction.replaceAll("rozw&#24", "rozwój");
            return correctBranch;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return "Do poprawki";
        }
    }

    private String searchForDataBranchAlt(Element element) {
        try {
            String script = element.getElementsByTag("script")
                    .first().nextElementSibling().html();
            String branch = script.substring(script.indexOf("=") + 3, script.indexOf(";") - 1);
            String correction = branch.replaceAll("Rozw&#24", "Rozwój oprogramowania");
            String correctBranch = correction.replaceAll("rozw&#24", "rozwój");
            return correctBranch;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return "Brak danych";
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
            return "Brak danych";
        } finally {
            return "Brak danych";
        }
    }

    private String searchForEmployer(Element element) {
        String employer =
                element.select("h2#offerEmployer").text();
        return employer;
    }

    private String searchForPosition(Element element) {
        String position =
                element.select("h1#offerTitle").text();
        return position;
    }

    private String searchForWorkplace(Element element) {
        String workplace =
                element.select("span[itemprop = addressRegion]").text();
        String correctWorkplace = workplace.replaceAll("pokaż mapę", "");
        return correctWorkplace;
    }

    private String searchForLocation(Element element) {
        String location = searchForWorkplace(element);
        String correctLocation = null;
        try {
            correctLocation = location.substring(0, location.lastIndexOf(","));
        } catch (StringIndexOutOfBoundsException e) {
            return location;
        }
        return correctLocation;
    }

    private String searchForEmploymentType(Element element) {
        String employmentType =
                element.select("span[itemprop = employmentType]").text();
        return employmentType;
    }

    private String searchForDatePublished(Element element) {
        String datePublished =
                element.select("span[itemprop = datePosted]").text();
        return datePublished;
    }

    private String searchForEmploLink(Element element) {
        String emploLink =
                element.select("a#emploLink").attr("href");
        return emploLink;
    }

    private String searchForDataId(Element element) {
        try {
            String script = element.getElementsByTag("script")
                    .last()
                    .previousElementSibling()
                    .html();
            String dataId = script.substring(
                    script.indexOf("'id':") + 7,
                    script.indexOf("price") - 5);
            return dataId;
        } catch (NullPointerException e) {
            return "Do poprawki";
        } catch (StringIndexOutOfBoundsException e) {
            return "Do poprawki";
        } finally {
            return "Brak danych";
        }
    }

      private String searchForDataIdAlt(Element element) {
        try {
            String scriptAlt = element
                    .select("div.main")
                    .last()
                    .previousElementSibling()
                    .html();
            String dataIDAlt = scriptAlt.substring(
                    scriptAlt.indexOf("identifier:") + 13,
                    scriptAlt.indexOf("fn:") - 5);
            return dataIDAlt;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return "Brak danych";
        }
    }
}






