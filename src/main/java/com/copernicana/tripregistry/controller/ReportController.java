package com.copernicana.tripregistry.controller;

import com.copernicana.tripregistry.repository.*;
import com.copernicana.tripregistry.service.SightseeingService;
import com.copernicana.tripregistry.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {
     
    @Autowired private TripService tripService;
    @Autowired private SightseeingService sightseeingService;
    @Autowired private PlanetariumRepository planetariumRepository;
    @Autowired private GingerbreadRepository gingerbreadRepository;
    @Autowired private FortIVRepository fortIVRepository;
    @Autowired private BeerRepository beerRepository;
    @Autowired private MealRepository mealRepository;
    @Autowired private MillRepository millRepository;
    @Autowired private CruiseRepository cruiseRepository;
    @Autowired private TeutonicCastleRepository teutonicCastleRepository;
    @Autowired private AdditionalAttractionsRepository additionalAttractionsRepository;
    
    
    @GetMapping("/sightseeings")
    public String getSightseeingsReport(Model model) {
        model.addAttribute("seeings", sightseeingService.getAllSighteeings());
        return "sightseeings";
    }


    //Prawdopodobnie do ukrycia - zostanie jeden raport z wyżywieniem dla wszystkich
    @GetMapping("/gesia")
    public String getGesiaReport(Model model) {
        model.addAttribute("meals", mealRepository.findAll());
        return "meals";
    }
    
      @GetMapping("/planetarium")
    public String getPlanetariumReport(Model model) {
        model.addAttribute("planets", planetariumRepository.findAll());
        return "planetariums";
    }
    
        @GetMapping("/gingerbread")
    public String getGingerbreadReport(Model model) {
        model.addAttribute("gingerbreads", gingerbreadRepository.findAll());
        return "gingerbread";
    }
    
       @GetMapping("/fort")
    public String getFortReport(Model model) {
        model.addAttribute("forts4", fortIVRepository.findAll());
        return "fort4";
    }

    //Być może do ukrycia, kwestia do obgadania
       @GetMapping("/olbracht")
    public String getOlbrachtReport(Model model) {
        model.addAttribute("beers", beerRepository.findAll());
        return "beer";
    }

    @GetMapping("/mlyny")
    public String getMillsReport(Model model) {
        model.addAttribute("mills", millRepository.findAll());
        return "mill";
    }

    @GetMapping("/castle")
    public String getCastleReport(Model model) {
        model.addAttribute("castle", teutonicCastleRepository.findAll());
        return "teutonicCastle";
    }

    @GetMapping("/cruise")
    public String getCruiseReport(Model model) {
        model.addAttribute("cruises", cruiseRepository.findAll());
        return "cruise";
    }

    @GetMapping("/additional")
    public String getAddtitionalAttractionReport(Model model) {
        model.addAttribute("additionalAttractions", additionalAttractionsRepository.findAll());
        return "additional";
    }


}
