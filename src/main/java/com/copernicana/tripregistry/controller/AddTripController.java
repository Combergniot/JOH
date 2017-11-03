package com.copernicana.tripregistry.controller;

import com.copernicana.tripregistry.model.trip.Company;
import com.copernicana.tripregistry.model.trip.Group;
import com.copernicana.tripregistry.model.trip.Meal;
import com.copernicana.tripregistry.model.trip.Trip;
import com.copernicana.tripregistry.service.MainFormDataConverter;
import com.copernicana.tripregistry.service.TripService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddTripController {

    
    @Autowired
    private MainFormDataConverter formDataConverter;
    @Autowired
    private TripService tripService;

    @GetMapping("/addTrip")
    public String getMainForm(Model model) {

        return "mainForm";
    }

    @PostMapping("/addTrip")
    public String handleMainForm(Model model,
            @RequestParam Map<String, String> params,
            @RequestParam("childrenNr") String[] childrenNr,
            @RequestParam("AdultsNr") String[] adultsNr,
            @RequestParam("StaffNr") String[] staffNr,
            @RequestParam("groupType") String[] groupType,
            @RequestParam("mealsType") String[] mealsType,
            @RequestParam("feedDate") String[] feedDate,
            @RequestParam("feedHour") String[] feedHour,
            @RequestParam("feedingPlace") String[] feedingPlace
    ) {

        Trip trip = 
        formDataConverter.convertToTrip(params, childrenNr, adultsNr, staffNr, groupType, mealsType, feedDate, feedHour, feedingPlace);
        
        tripService.addTrip(trip);

        return "redirect:addTrip";
    }

}
