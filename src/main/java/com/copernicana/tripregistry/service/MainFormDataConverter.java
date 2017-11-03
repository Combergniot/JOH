package com.copernicana.tripregistry.service;

import com.copernicana.tripregistry.controller.AddTripController;
import com.copernicana.tripregistry.model.trip.Accomodation;
import com.copernicana.tripregistry.model.trip.Company;
import com.copernicana.tripregistry.model.trip.Group;
import com.copernicana.tripregistry.model.trip.Meal;
import com.copernicana.tripregistry.model.trip.Trip;
import com.copernicana.tripregistry.repository.CompanyRepository;
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
import org.springframework.stereotype.Service;

@Service
public class MainFormDataConverter {
    
    @Autowired
    private CompanyRepository companyRepository;

    public Trip convertToTrip(
            Map<String, String> params,
            String[] childrenNr,
            String[] adultsNr,
            String[] staffNr,
            String[] groupType,
            String[] mealsType,
            String[] feedDate,
            String[] feedHour,
            String[] feedingPlace
            ) {
        
        // Date format for every date in form
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", new Locale.Builder().setLanguage("pl").setRegion("PL").build());
        
        // Start and end dates of the trip
        Date tripStartDate = new Date();
        Date tripEndDate = new Date();
        
        try {
            tripStartDate = format.parse(params.get("tripStartDate"));
            tripEndDate = format.parse(params.get("tripEndDate"));
            
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
                
        // Initalize new trip with dates
        Trip trip = new Trip();
        trip.setDateFrom(tripStartDate);
        trip.setDateTo(tripEndDate);       

        // Initialize new group
        // first element of array is in case there are multiple groups later
        Group group = new Group();
        group.setAdultsNo(Integer.parseInt(adultsNr[0]));
        group.setChildrenNo(Integer.parseInt(childrenNr[0]));
        group.setStaffNo(Integer.parseInt(staffNr[0]));
        group.setTrip(trip);
        group.setAge(groupType[0]);
        trip.setGroup(group);

        // Initialize meals
        List<Meal> meals = new ArrayList<>();
        for (int i = 0; i < mealsType.length; i++) {
            Meal meal = new Meal();
            meal.setMealType(mealsType[i]);
            meal.setPlace(feedingPlace[i]);
            // pobierz restauracje z bazy
            
            
            try {
                meal.setDate(format.parse(feedDate[i]));
            } catch (ParseException ex) {
                Logger.getLogger(AddTripController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            meal.setHour(feedHour[i]);
            meal.setTrip(trip);
            meals.add(meal);
        }
        
        trip.setMeals(meals);
        
        // Initialize company
        // pobierz numerek firmy
        // ciagnij firme z dao
        // zapisz

      //  Company company = (Company) companyRepository.findOne(Long.parseLong(params.get("company")));
       // company.setName(params.get("companyName"));
      //  company.setTrip(trip);
     //   trip.setCompany(company);

      //  System.out.println("DANE WYCIECZKI: " + trip);
      
      Date acomDateStart = new Date();
      Date acomDateEnd = new Date();
      
      // Initialize accomodation
        try {
            acomDateStart = format.parse(params.get("acomDateStart"));
            acomDateEnd = format.parse(params.get("acomDateEnd"));
            
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        
      List<Accomodation> accomodations = new ArrayList<>();
      Accomodation accomodation = new Accomodation();
      accomodation.setDateFrom(acomDateStart);
      accomodation.setDateTo(acomDateEnd);
      accomodation.setHotelName(params.get("acomHotel"));
      accomodation.setTrip(trip);
      accomodations.add(accomodation);
      trip.setAccomodations(accomodations);
      

      // initialize attractionsWithGuide




      
      // initialize mainAttractions






      //initialize additionalAttraction


        

        return trip;
        
        
    }

}
