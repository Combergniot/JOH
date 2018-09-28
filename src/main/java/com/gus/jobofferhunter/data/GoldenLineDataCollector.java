package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.model.offer.GoldenLine;
import com.gus.jobofferhunter.model.offer.JobsPl;
import com.gus.jobofferhunter.service.GoldenLineService;
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
import java.util.ArrayList;
import java.util.List;

//TODO - wyrzucić ul.items-list js-job-predicted - blok ofert promowanych. Zastanowić się czy wchodzić w szczegóły - dla branży

@Component
public class GoldenLineDataCollector extends DataCollectorSettings {

    @Autowired
    GoldenLineService goldenLineService;

    private static final Logger log = LoggerFactory.getLogger(GoldenLineDataCollector.class);

    /**
     * Collects links to all websites with offers from the portal "goldenline.pl".
     * GoldenLine blocks ip adresses. Math.random for Thread try to proves that "I am not a robot".
     */
    public void collectStructure() throws Exception {
        List<String> paginationList = new ArrayList<>();
        paginationList.add("https://www.goldenline.pl/praca/szukaj");
        for (int i = 0; i < paginationList.size(); i++) {
            Thread.sleep(4000 + (long) Math.random() * 3000);
            Document paginationPage = Jsoup.connect(paginationList.get(i))
                    .proxy("10.51.55.34", 8080)
                    .userAgent(USER_AGENT)
                    .referrer(REFERRER)
                    .timeout(12000)
                    .followRedirects(true)
                    .get();
            Elements pagination = paginationPage.select(".list-unstyled >li.next >a");
            for (Element e : pagination) {
                String url = e.attr("abs:href");
                paginationList.add(url);
            }
            log.info(paginationList.get(i));
        }
    }

    public void collectTestData() throws Exception {
        log.info("The data downloading is in progress...");
        for (int counter = 1; counter <= 182; counter++) {
            Thread.sleep(3000 + (long) Math.random() * 2000);
            Document singleOffer = null;
            try {
                singleOffer = Jsoup
                        .connect("https://www.goldenline.pl/praca/szukaj" + counter)
                        .proxy("10.51.55.34", 8080)
                        .userAgent(USER_AGENT)
                        .referrer(REFERRER)
                        .timeout(12000)
                        .ignoreHttpErrors(true)
                        .followRedirects(true)
                        .get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements jobOfferList = singleOffer.select("ul.items-list")
                    .not("ul.items-list.js-job-predicted");
            Elements singleOfferBox = jobOfferList.select("li.stats-data-offer");
            for (Element element : singleOfferBox) {
                GoldenLine goldenLine = new GoldenLine();
                goldenLine.setPosition(searchForPosition(element));
                goldenLine.setEmployer(searchForEmployer(element));
                goldenLine.setUrl(searchForUrl(element));
                goldenLine.setDatePublished(searchForDatePublished(element));
                goldenLine.setDataId(searchForDataId(element));
                goldenLine.setWebPage("goldenline.pl");
                goldenLine.setWorkplace(searchForWorkplace(element));
                goldenLine.setDataSearch(LocalDateTime.now().format(formatter));
                goldenLineService.save(goldenLine);

                log.info("The data from single offer was downloaded...");
            }
            counter++;
        }

        log.info("All data from the goldenline.pl has been downloaded");
    }

    private String searchForPosition(Element element) {
        String position =
                element.select("a > div.text > h3.position").text();
        return position;
    }

    private String searchForEmployer(Element element) {
        String employer =
                element.select("a > div.text > div.company").text();
        return employer;
    }

    private String searchForUrl(Element element) {
        String url =
                element.select("a.cell.content").attr("href");
        return url;
    }

    private String searchForDatePublished(Element element) {
        String datePublished =
                element.select("span[property = datePosted]").text();
        return datePublished;
    }

    private String searchForDataId(Element element) {
        String dataId =
                element.attr("data-id");
        return dataId;
    }

    private String searchForWorkplace(Element element) {
        String workplace =
                element.select("span[property=addressLocality]").text();
        return workplace;
    }
}


