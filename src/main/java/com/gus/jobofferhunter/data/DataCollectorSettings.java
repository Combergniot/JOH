package com.gus.jobofferhunter.data;

import java.time.format.DateTimeFormatter;
import java.util.*;

public abstract class DataCollectorSettings {

    protected static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) " +
                    "AppleWebKit/537.36 (KHTML, like Gecko) " +
                    "Chrome/45.0.2454.101 Safari/537.36";
    protected static final String REFERRER = "http://www.google.com";
    protected List<String> paginationList = new ArrayList<>();
    protected List<String> jobOffersList = new ArrayList<>();
    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    protected Set<String> paginationSet = new HashSet<>();


    protected List removeDuplicatesFromList() {
        paginationSet.addAll(jobOffersList);
        jobOffersList.clear();
        jobOffersList.addAll(paginationSet);
        return jobOffersList;
    }

}
