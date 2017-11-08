package com.gus.jobofferhunter.controller;

import com.gus.jobofferhunter.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {

    @Autowired
    private JobOfferRepository jobOfferRepository;
    @Autowired
    private GazetaPracaRepository gazetaPracaRepository;
    @Autowired
    private GoldenLineRepository goldenLineRepository;
    @Autowired
    private GratkaRepository gratkaRepository;
    @Autowired
    private MoneyPlRepository moneyPlRepository;
    @Autowired
    private OlxRepository olxRepository;
    @Autowired
    private PracujPlRepository pracujPlRepository;


    @GetMapping("/main_report")
    public String getMainReport(Model model) {
        model.addAttribute("jobOffers", jobOfferRepository.findAll());
        return "mainReport";
    }


    //Prawdopodobnie do ukrycia - zostanie jeden raport z wyżywieniem dla wszystkich
    @GetMapping("/goldenline")
    public String getGoldenLineReport(Model model) {
        model.addAttribute("goldenLineOffers", goldenLineRepository.findAll());
        return "goldenline";
    }

    @GetMapping("/gratka")
    public String getGratkaReport(Model model) {
        model.addAttribute("gratkaOffers", gratkaRepository.findAll());
        return "gratka";
    }

    @GetMapping("/gazetapraca")
    public String getGazetaPracaReport(Model model) {
        model.addAttribute("gazetaPracaOffers", gazetaPracaRepository.findAll());
        return "gazetapraca";
    }

    @GetMapping("/pracujpl")
    public String getPracujPlReport(Model model) {
        model.addAttribute("pracujPlOffers", pracujPlRepository.findAll());
        return "pracujpl";
    }

    @GetMapping("/olx")
    public String getOlxReport(Model model) {
        model.addAttribute("olxOffers", olxRepository.findAll());
        return "olx";
    }

    @GetMapping("/moneypl")
    public String getMoneyPlReport(Model model) {
        model.addAttribute("moneyPlOffers", moneyPlRepository.findAll());
        return "money";
    }




}
