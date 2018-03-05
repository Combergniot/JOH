package com.gus.jobofferhunter.controller;

import com.gus.jobofferhunter.model.offer.Gratka;
import com.gus.jobofferhunter.service.GratkaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gratkaList")
public class GratkaController {

    private final GratkaService gratkaService;

       public GratkaController(GratkaService gratkaService) {
        this.gratkaService = gratkaService;
    }

    @GetMapping("/list")
    public Iterable<Gratka> list() {
        return gratkaService.list();
    }
}
