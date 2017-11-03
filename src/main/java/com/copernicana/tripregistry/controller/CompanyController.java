package com.copernicana.tripregistry.controller;

import com.copernicana.tripregistry.model.trip.Company;
import com.copernicana.tripregistry.repository.CompanyRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {
    
    @Autowired
    private CompanyRepository companyRepository;
    
    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public @ResponseBody
    List<Company> getCompanies() {
 
        List<Company> companies = new ArrayList<>();
        Iterable<Company> companiesIterable = companyRepository.findAll();
        companiesIterable.forEach(companies::add);

        return companies;
    }

}
