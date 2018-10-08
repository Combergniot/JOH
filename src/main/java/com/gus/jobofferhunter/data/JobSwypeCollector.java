package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.model.offer.JobSwype;
import com.gus.jobofferhunter.service.JobSwypeService;
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

//Trzeba manipulować adresem
//https://www.jobswype.pl/praca?title=&location=&radius=0&sorting=&display=&page=99
//Disallow: /praca?title=*
@Component
public class JobSwypeCollector extends DataCollectorSettings {

    @Autowired
    JobSwypeService jobSwypeService;

    private static final Logger log = LoggerFactory.getLogger(JobSwype.class);

    private int findLastPaginationNumber() throws IOException {
        Document navbar = Jsoup
                .connect("https://www.jobswype.pl/praca?title=&location=&radius=0&sorting=&display=&page=")
                .proxy("10.51.55.34", 8080)
                .userAgent(USER_AGENT)
                .referrer(REFERRER)
                .timeout(12000)
                .ignoreHttpErrors(true)
                .followRedirects(true)
                .get();
        String element = navbar.select("p.text-center.small").text();
        String corrections =
                element
                        .replaceAll("Około ", "")
                        .replaceAll(" wyników", "")
                        .replace(".","");
        Integer lastPaginationNumber = Integer.parseInt(corrections)/10;
        System.out.println(lastPaginationNumber);
        return lastPaginationNumber;
     }

    private void fillPaginationList() throws IOException {
        int number = findLastPaginationNumber();
        for (int i = 1; i <= number; i++) {
            String link = "https://www.jobswype.pl/praca?title=&location=&radius=0&sorting=&display=&page=";
            paginationList.add(link + i);
        }
    }

    public void collectData() throws IOException, InterruptedException {
        fillPaginationList();
        for (int i = 0; i < paginationList.size(); i++) {
            Thread.sleep(3000 + (long) Math.random() * 2000);
            Document singleOffer = Jsoup.connect(paginationList.get(i))
                    .proxy("10.51.55.34", 8080)
                    .userAgent(USER_AGENT)
                    .referrer(REFERRER)
                    .timeout(12000)
                    .ignoreHttpErrors(true)
                    .followRedirects(true)
                    .get();
            JobSwype jobSwype = new JobSwype();
            Elements content = singleOffer.select("div#content>div.job.card.mb-1");
            for (Element element : content) {
                jobSwype.setPosition(searchForPosition(element));
                jobSwype.setWebPage("JobSwype");
                jobSwype.setWorkplace(searchForWorkplace(element));
                jobSwype.setDatePublished(searchForDatePublished(element));
                jobSwype.setTypeOfWork(searchForTypeOfWork(element));
                jobSwype.setUrl(searchForUrl(element));
                jobSwype.setDataSearch(LocalDateTime.now().format(formatter));
                jobSwypeService.save(jobSwype);
                log.info("The data from single page was downloaded...");
            }
            log.info("Links to all job offers from JobSwype.pl has been downloaded!");
        }
    }

    private String searchForUrl(Element element) {
        String url = "";
        return url;
    }

    private String searchForTypeOfWork(Element element) {
        String typeOfWork = "";
        return typeOfWork;
    }

    private String searchForWorkplace(Element element) {
        String workplace = "";
        return workplace;
    }

    private String searchForPosition(Element element) {
        String position = element.select("div.card-header").text();
        return position;
    }

    private String searchForDatePublished(Element element) {
        String datePublished = "";
        return datePublished;
    }

}
