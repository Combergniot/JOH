package com.gus.jobofferhunter.model.offer;

//TODO - oferty pracy dla lingwistów - http://www.linguajob.pl/szukaj/?p=2

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor

@Entity
@DiscriminatorValue("linguajob")
public class LinguaJob extends JobOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
