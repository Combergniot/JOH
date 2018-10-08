package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.processing.PracujPlDataProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Scrapper {

    @Autowired
    GratkaDataCollector gratkaDataCollector;
    @Autowired
    MoneyPlDataCollector moneyPlDataCollector;
    @Autowired
    OlxDataCollector olxDataCollector;
    @Autowired
    PracujPlDataCollector pracujPlDataCollector;
    @Autowired
    GoldenLineDataCollector goldenLineDataCollector;
    @Autowired
    LinkedinDataCollector linkedinDataCollector;
    @Autowired
    JobsPlDataCollector jobsPlDataCollector;
    @Autowired
    AllTheJobsCollector allTheJobsCollector;
    @Autowired
    GumtreeCollector gumtreeCollector;
    @Autowired
    CareerJetCollector careerJetCollector;
    @Autowired
    InfoPracaCollector infoPracaCollector;
    @Autowired
    AbsolventCollector absolventCollector;
    @Autowired
    PracujPlDataProcessing pracujPlDataProcessing;
    @Autowired
    AdzunaCollector adzunaCollector;
    @Autowired
    GazetaPracaCollector gazetaPracaCollector;
    @Autowired
    PracaOwiCollector pracaOwiCollector;
    @Autowired
    JobSwypeCollector jobSwypeCollector;
    @Autowired
    LinguaJobCollector linguaJobCollector;


    public void downloadDataFromPracujPl() throws Exception {
        pracujPlDataCollector.downloadAll();
    }

    public void downloadDataFromGratka() throws Exception {
        gratkaDataCollector.downloadAll();
    }

    public void downloadDataFromOlx() throws Exception {
        olxDataCollector.downloadAll();
    }

    public void downloadDataFromMoneyPl() throws Exception {
        moneyPlDataCollector.downloadALL();
    }

    public void downloadDataFromGoldenLine() throws Exception {
        System.out.println("WORK IN PROGRESS! GoldenLine Scrapper is currently under technical maintenance");
    }

    public void downloadDataFromLinkedin() throws Exception {
        System.out.println("WORK IN PROGRESS! Linkedin Scrapper is currently under technical maintenance");
        System.out.println("ACCESS DENIED!");
    }

    public void downloadDataFromJobsPl() throws Exception {
        jobsPlDataCollector.downloadAll();
    }

    public void downloadDataFromAllTheJobs() throws Exception {
        allTheJobsCollector.downloadAll();
    }

    public void downloadDataFromGumtree() throws Exception {
        gumtreeCollector.downloadAll();
    }

    public void downloadDataFromCareerJet() throws Exception {
        System.out.println("WORK IN PROGRESS! CareerJet Scrapper is currently under technical maintenance");
        System.out.println("PAGINATION LIMIT!");
    }

    public void downloadDataFromInfoPraca() throws Exception {
        infoPracaCollector.downloadAll();
    }

    public void downloadDataFromAbsolvent() throws Exception {
        System.out.println("WORK IN PROGRESS! Absolvent Scrapper is currently under technical maintenance");
    }

    public void downloadDataFromAdzuna() throws Exception {
        adzunaCollector.collectData();
    }

    public void downloadDataFromGazetaPraca() throws Exception {
        System.out.println("WORK IN PROGRESS! GazetaPraca Scrapper is currently under technical maintenance");
    }

    public void downloadDataFromPracaOwi() throws Exception {
        System.out.println("WORK IN PROGRESS! PracaOwi Scrapper is currently under technical maintenance");
    }

    public void downloadDataFromJobSwype() throws Exception {
        System.out.println("WORK IN PROGRESS! JobSwype Scrapper is currently under technical maintenance");
        jobSwypeCollector.collectData();

    }

    public void downloadDataFromLinguaJob() throws Exception {
        linguaJobCollector.collectData();
    }

}
