package com.copernicana.tripregistry.mockdata;

import com.copernicana.tripregistry.model.trip.Accomodation;
import com.copernicana.tripregistry.model.trip.Company;
import com.copernicana.tripregistry.model.trip.Group;
import com.copernicana.tripregistry.model.trip.Meal;
import com.copernicana.tripregistry.model.trip.Trip;
import com.copernicana.tripregistry.model.trip.attraction.Attraction;
import com.copernicana.tripregistry.model.trip.attraction.Beer;
import com.copernicana.tripregistry.model.trip.attraction.FortIV;
import com.copernicana.tripregistry.model.trip.attraction.Gingerbread;
import com.copernicana.tripregistry.model.trip.attraction.Planetarium;
import com.copernicana.tripregistry.model.trip.guideusage.GuideUsage;
import com.copernicana.tripregistry.model.trip.guideusage.Sightseeing;
import com.copernicana.tripregistry.service.TripServiceImpl;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddFakeData {

    @Autowired
    TripServiceImpl tripService;

    public void addData() {

        List<Trip> trips = createTrips();
        

        for (Trip trip : trips) {
            System.out.println(trip);
            tripService.addTrip(trip);
        }
    }

    private List<Trip> createTrips() {

        Date day1 = getDateForTrip(20);
        Date day2 = getDateForTrip(21);

        Trip testTrip1 = new Trip();
        testTrip1.setDateFrom(day1);
        testTrip1.setDateTo(day2);

        List<Trip> trips = new ArrayList<>();
        trips.add(testTrip1);

     //   Company company1 = new Company();
    //    company1.setName("Instytut gały i pały");
     //   company1.setTrip(testTrip1);
    //    testTrip1.setCompany(company1);

        Group group1 = new Group();
        group1.setAdultsNo(25);
        group1.setChildrenNo(0);
        group1.setStaffNo(2);
        group1.setAge("Seniorzy");
        testTrip1.setGroup(group1);
        group1.setTrip(testTrip1);

        List<Meal> meals1 = new ArrayList<>();
        meals1.add(new Meal(day1, "09:00", "sniadanie", "hotel Awruk",testTrip1));
        meals1.add(new Meal(day1, "15:00", "obiad", "Gesia",testTrip1));
        meals1.add(new Meal(day2, "12:00", "obiad", "hotel",testTrip1));
        testTrip1.setMeals(meals1);
        

        List<Accomodation> accomodations1 = new ArrayList<>();
        accomodations1.add(new Accomodation(day1, "Hotel Awruk"));
        testTrip1.setAccomodations(accomodations1);

//        List<GuideUsage> guideUsages1 = new ArrayList<>();
//        guideUsages1.add(new Sightseeing(day2, "14.00",true, true, true, true, "zwiedzanie tradycyjne", testTrip1));
//        guideUsages1.add(new Sightseeing(day2, "15.00",false, true, true, false, "torun frywolny", testTrip1));
//        testTrip1.setAttractionsWithGuide(guideUsages1);

        List<Attraction> attractions1 = new ArrayList<>();
        attractions1.add(new Beer(true, true, true, day2, "11.30", "piwkowanie", testTrip1));
        attractions1.add(new Planetarium("seans porno", day2, "14.45", "Seans", testTrip1));
        attractions1.add(new FortIV(false, true, false, false, day1, "17.30", "fort", testTrip1));
        testTrip1.setAttractions(attractions1);
        
        
        
        
        // TRIP 2
        Date day3 = getDateForTrip(23);
        Date day4 = getDateForTrip(28);

        Trip testTrip2 = new Trip();
        testTrip2.setDateFrom(day3);
        testTrip2.setDateTo(day4);
List<Trip> company2Trips = new ArrayList<>();
company2Trips.add(testTrip2);
        
        trips.add(testTrip2);

       Company company2 = new Company();
       company2.setName("Marimpex");
      
       company2.setTrips(company2Trips);
       //company2.setTrip(testTrip2);
      testTrip2.setCompany(company2);

        Group group2 = new Group();
        group2.setAdultsNo(15);
        group2.setChildrenNo(0);
        group2.setStaffNo(2);
        group2.setAge("Dorośli");
        testTrip2.setGroup(group2);
        group2.setTrip(testTrip2);

        List<Meal> meals2 = new ArrayList<>();
        meals2.add(new Meal(day3, "09:00", "sniadanie", "hotel MarkizDeSade",testTrip2));
        meals2.add(new Meal(day3, "14:00", "obiad", "Gesia",testTrip2));
        meals2.add(new Meal(day4, "13:30", "obiad", "hotel",testTrip2));
        testTrip2.setMeals(meals2);
        

        List<Accomodation> accomodations2 = new ArrayList<>();
        accomodations2.add(new Accomodation(day3, "Hotel MarkizDeSade"));
        testTrip2.setAccomodations(accomodations2);

     //   List<GuideUsage> guideUsages2 = new ArrayList<>();
      //  guideUsages2.add(new Sightseeing(day3, "14.00",false, true, false, true, "zwiedzanie tradycyjne", testTrip2));
     //   guideUsages2.add(new Sightseeing(day4, "15.00",true, false, true, true, "torun frywolny", testTrip2));
     //   testTrip2.setAttractionsWithGuide(guideUsages2);

        List<Attraction> attractions2 = new ArrayList<>();
        attractions2.add(new Beer(true, true, false, day3, "11.30", "piwkowanie", testTrip2));
        attractions2.add(new Planetarium("seans nienawiści", day4, "14.45", "Seans", testTrip2));
        attractions2.add(new Planetarium("ucieczka z kina wolnosc", day4, "18.45", "seanss", testTrip2));
        attractions2.add(new FortIV(true, true, true, false, day4, "18.30", "fort", testTrip2));
        attractions2.add(new Gingerbread(true, day4, "13.15", "pierniczki", testTrip2));
        testTrip2.setAttractions(attractions2);
        

//  Trip testTrip2 = new Trip();
        //  Trip testTrip3 = new Trip();
        //  Trip testTrip4 = new Trip();
        //  Trip testTrip5 = new Trip();
        return trips; 
    }

// metoda do szybkiego dodawania roznych dat 
    private Date getDateForTrip(int daysFromToday) {
        Date myDate = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);
        cal.add(Calendar.DATE, daysFromToday);
        return cal.getTime();
    }
}
