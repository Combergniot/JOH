package com.gus.jobofferhunter.data;

//https://developer.adzuna.com/overview
//

import com.gus.jobofferhunter.api.AdzunaApiService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AdzunaCollector extends DataCollectorSettings {

    AdzunaApiService adzunaApiService = new AdzunaApiService();

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
                        "?app_id=" + adzunaApiService.getApplicationId()+
                        "&app_key=" + adzunaApiService.getApplicationKey()+
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

}


