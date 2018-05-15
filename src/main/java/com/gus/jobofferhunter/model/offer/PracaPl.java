package com.gus.jobofferhunter.model.offer;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

//TODO - 5-6tys ofert - https://www.praca.pl/oferty-pracy.html

@Data
@AllArgsConstructor

@Entity
@DiscriminatorValue("pracapl")
public class PracaPl extends JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    public PracaPl() {
    }
}